package com.netease.parse;

import com.netease.util.ParseReportUtil;


public class ReportPaser {

//	private static final String PATH = "E:/temp/creditreport.html";
	private static final String PATH = "E:/temp/creditreport.html";
	
	public static void main(String[] agrs) {
		ParseReportUtil.parseBasic(PATH);
//		ParseReportUtil.parseTest(PATH);
//		ParseReportUtil.parseFromLocalHTML(PATH);
	}
}
