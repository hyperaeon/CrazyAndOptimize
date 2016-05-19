package com.credit.http;

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
		String httpOrgCreateTest = url + "page/login/loginreg.jsp";
//		String httpOrgCreateTest = url + "login.do";
		//String httpOrgCreateTest = url;
		Map<String,String> createMap = new HashMap<String,String>();
//		createMap.put("username","jonney_zh");
//		createMap.put("password","ml520zl");
//		createMap.put("_@IMGRC@_","rcrbax");
//		createMap.put("method","login");
//		createMap.put("date","1463554692005");
//		createMap.put("org.apache.struts.taglib.html.TOKEN","01122162548934f9be26b07ebb613d82");
		createMap.put("loginname","jonney_zh");
		createMap.put("password","ml520zl");
		createMap.put("_@IMGRC@_","bkp4r4");
		createMap.put("jsessionid","1rRxX8WhV4yLhlMRrTQybqWymLVbXvQF4qt1JkQnWSHDyJpv9B9H!385023987");
		createMap.put("org.apache.struts.taglib.html.TOKEN","1378fa4a947176338bf773e90cad4d7e");
		
		
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