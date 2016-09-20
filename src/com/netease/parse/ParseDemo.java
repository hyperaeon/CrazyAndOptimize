package com.netease.parse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.htmlparser.Parser;
import org.htmlparser.visitors.TextExtractingVisitor;

import com.netease.util.ParseReportUtil;

public class ParseDemo {

	private static final String PATH = "E:/temp/reg1.html";
	
	private static final String ENCODE = "UTF-8";
	
	public static void main(String[] args) {
//		parseFromURL();
//		parseFromLocalHTML();
		ParseReportUtil.parseBasic(PATH);
	}
	
	/**
	 * 从本地读取的html文件中解析
	 */
	private static void parseFromLocalHTML() {
		String content = openFile(PATH);
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
	 * 从URL解析
	 */
	private static void parseFromURL () {
		try {
			Parser parser = new Parser((HttpURLConnection) 
					new URL("http://www.baidu.com").openConnection());
			TextExtractingVisitor visitor = new TextExtractingVisitor();
			parser.visitAllNodesWith(visitor);
			String textInPage = visitor.getExtractedText();
			System.out.println(textInPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
