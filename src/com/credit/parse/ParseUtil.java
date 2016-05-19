package com.credit.parse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.credit.dto.AllInfoDTO;
import com.credit.dto.BasicInfoDTO;
import com.credit.dto.CheckRecordDTO;
import com.credit.dto.LoanRecordDTO;
import com.credit.dto.PublicRecordDTO;

public class ParseUtil {

	private static final String ENCODE = "UTF-8";
	
	private static final String COLON = "：";

	private static AllInfoDTO all;
	
	static {
		all = new AllInfoDTO();
		all.setBasicInfoDTO(new BasicInfoDTO());
		all.setCheckRecordDTO(new CheckRecordDTO());
		all.setLoanRecordDTO(new LoanRecordDTO());
		all.setPublicRecordDTO(new PublicRecordDTO());
	}
	
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
			if (CollectionUtils.isNotEmpty(tableTagList)) {
				for (int i = 0; i < tableTagList.size(); i++) {
					parseTables(tableTagList, i);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param tableTagList
	 * @return
	 */
	private static void parseTables(List<TableTag> tableTagList, int i) {
		if (i == 0) {
			parseTableOne(tableTagList);
		}
	}
	
	/**
	 * 将第一个table中的内容解析出来
	 * @param content
	 */
	private static void parseTableOne(List<TableTag> tableTagList) {
		String content = tableTagList.get(0).getChildrenHTML();
		try {
			Parser parser = Parser.createParser(content, ENCODE);
			TextExtractingVisitor visitor = new TextExtractingVisitor();
            parser.visitAllNodesWith(visitor);
            String textInPage = visitor.getExtractedText();//获取table中的文本
            String[] strArray = null;
            if (StringUtils.isNotBlank(textInPage)) {
            	System.out.println(textInPage.replaceAll("\\s+", " "));
            	strArray = textInPage.replaceAll("\\s+", " ").split(" ");
            }
            System.out.println(strArray.length);
            List<String> elements = new ArrayList<String>();//保存解析后的所有文本内容
            if (strArray != null) {
            	for (String str : strArray) {
            		System.out.println(str);
            		if (StringUtils.isNotBlank(str)) {
            			elements.add(str.trim());
            		}
            	}
            }
            for (String element : elements) {
            	System.out.println(element);
            }
            buildBasicInfor(elements);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 设置基本信息
	 */
	private static void buildBasicInfor(List<String> elements) {
		BasicInfoDTO basic = all.getBasicInfoDTO();
		basic.setReportNumber(elements.get(2));
		basic.setReportTime(convertString2Date(extractDateString(elements.get(3),elements.get(4))));
		basic.setQueryTime(convertString2Date(extractDateString(elements.get(5),elements.get(6))));
		System.out.println(basic.getReportNumber());
		System.out.println(basic.getReportTime());
		System.out.println(basic.getQueryTime());
		
	}
	
	/**
	 * str1="查询时间：2016.04.29"
	 * str2 = "21:13:30"
	 * @param str1
	 * @param str2
	 * @return
	 */
	private static String extractDateString(String str1, String str2) {
		StringBuilder builder = new StringBuilder();
		str1 = str1.replaceAll("\\.", "-");
		builder.append(str1.substring(str1.indexOf(COLON) + 1).trim());
		builder.append(" ").append(str2);
		return builder.toString();
	}
	
	/**
	 * String类型转换成date
	 * @param time
	 * @return
	 */
	private static Date convertString2Date(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
}
