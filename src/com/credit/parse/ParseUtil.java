package com.credit.parse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;
import org.htmlparser.visitors.TextExtractingVisitor;

public class ParseUtil {

	private static final String ENCODE = "UTF-8";
	
	/**
	 * 打开本地文件
	 * @param fileName
	 * @return
	 */
	private static String openFile(String fileName) {
		StringBuilder builder = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream(new File(fileName)), ENCODE));
			String content = "";
			while ((content = br.readLine()) != null) {
				builder.append(content);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return builder.toString();
	}
	
	/**
	 * 从本地读取的html文件中解析
	 */
	public static void parseFromLocalHTML(String path) {
		String content = openFile(path);
		System.out.println(content);
		try {
			Parser parser = Parser.createParser(content, ENCODE);
			TextExtractingVisitor visitor = new TextExtractingVisitor();
            parser.visitAllNodesWith(visitor);
            String textInPage = visitor.getExtractedText();
            System.out.println(textInPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 打印消息
	 * @param szMsg
	 */
	private static void message(String szMsg) {
        try{ 
        	System.out.println(new String(szMsg.getBytes(ENCODE), System.getProperty("file.encoding"))); 
       } catch(Exception e){
    	   
        }
    }
	
	/**
	 * 解析测试
	 * @param path
	 */
	public static void parseTest(String path) {
		String content = openFile(path);
//		System.out.println("----源文件------" + content);
		try {
			Parser parser = Parser.createParser(content, ENCODE);
			for (NodeIterator i = parser.elements(); i.hasMoreNodes();) {
				Node node = i.nextNode();
//				message("getText:" + node.getText());
				message("getPlaninText:" + node.toPlainTextString());
//				message("toHtml:" + node.toHtml());
//				message("toHtml(true):" + node.toHtml(true));
//				message("toHtml(false)" + node.toHtml(false));
//				message("toString:" + node.toString());
				message("=============");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void parseBasic(String path) {
		String content = openFile(path);
		try {
			Parser parser = Parser.createParser(content, ENCODE);
			NodeFilter tableFilter = new NodeClassFilter(TableTag.class);
			OrFilter lastFilter = new OrFilter();
			lastFilter.setPredicates(new NodeFilter[]{tableFilter});
			NodeList nodeList = parser.parse(lastFilter);
			List<TableTag> tableTagList = new ArrayList<TableTag>();
			for (int i = 0; i < nodeList.size(); i++) {
				if (nodeList.elementAt(i) instanceof TableTag && i > 0) {//第一个为祖先table，第一个之后都是祖先table的孩子
					TableTag tag = (TableTag)nodeList.elementAt(i);
//					System.out.println(tag.getChildrenHTML());
					tableTagList.add(tag);
				}
			}
			//解析所有table
			parseTable(tableTagList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param tableTagList
	 * @return
	 */
	private static void parseTable(List<TableTag> tableTagList) {
		if (CollectionUtils.isNotEmpty(tableTagList)) {
			System.out.println(tableTagList.size());
			for (int i = 0; i < tableTagList.size(); i++) {
				if (i == 0 || i == 1) {
					parseContent(tableTagList.get(i).getChildrenHTML());
				}
			}
		}
	}
	
	/**
	 * 将table中的内容解析出来
	 * @param content
	 */
	private static void parseContent(String content) {
		try {
			Parser parser = Parser.createParser(content, ENCODE);
			TextExtractingVisitor visitor = new TextExtractingVisitor();
            parser.visitAllNodesWith(visitor);
            String textInPage = visitor.getExtractedText();//获取table中的文本
            String[] strArray = null;
            if (StringUtils.isNotBlank(textInPage)) {
            	strArray = textInPage.replaceAll("\t", " ").trim().split("\\s+");
            }
            System.out.println(strArray.length);
            if (strArray != null) {
            	for (String str : strArray) {
            		System.out.println(str);
            	}
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
