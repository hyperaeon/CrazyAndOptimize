package com.credit.parse;

import java.util.HashMap;
import java.util.Map;
//对接口进行测试
public class TestMain {
	private String url = "https://ipcrs.pbccrc.org.cn/";
	private String charset = "utf-8";
	private HttpClientUtil httpClientUtil = null;
	
	public TestMain(){
		httpClientUtil = new HttpClientUtil();
	}
	
	public void test(){
		//String httpOrgCreateTest = url + "page/login/loginreg.jsp";
		String httpOrgCreateTest = url + "login.do";
		//String httpOrgCreateTest = url;
		Map<String,String> createMap = new HashMap<String,String>();
		createMap.put("username","jonney_zh");
		createMap.put("password","ml520zl");
		createMap.put("_@IMGRC@_","ceq3ry");
		createMap.put("method","login");
		createMap.put("date","1463386588706");
	//	createMap.put("org.apache.struts.taglib.html.TOKEN","fcf25637ba9d9e3bec6d9f129671bb6d&method=login&date=1463376456608&loginname=jonney_zh&password=ml520zl&_%40IMGRC%40_=eh86c5");
		createMap.put("org.apache.struts.taglib.html.TOKEN","8f5aad5960281ea25065fa4300858290");
		
//		createMap.put("password","ml520zl");
//		createMap.put("_@IMGRC@_","hxarbb");
		String httpOrgCreateTestRtn = httpClientUtil.doPost(httpOrgCreateTest,createMap,charset);
		if(httpOrgCreateTestRtn==null){
			System.out.println("the result is null");
		}
		System.out.println("result:"+httpOrgCreateTestRtn);
	}
	
	public static void main(String[] args){
		TestMain main = new TestMain();
		main.test();
	}
}