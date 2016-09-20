package com.netease.credit.test;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;

/**
 * 
 * @ClassName: TestMain
 * @Description: 接口进行测试
 * @author:JonneyZhang
 * @date: 2016年5月17日 上午10:23:01
 */
public class TestMain {
	//
	private String url = "https://ipcrs.pbccrc.org.cn/"; //官网
	//private String url = "https://ipcrs.pbccrc.org.cn/page/login/loginreg.jsp/"; // 进入登陆页面的URL
	//private String url = "https://ipcrs.pbccrc.org.cn/simpleReport.do?method=viewReport&tradeCode=biakbe"; //获取征信报告URL
	private String charset = "utf-8";
	private HttpClientUtil httpClientUtil = null;
	
	public TestMain(){
		httpClientUtil = new HttpClientUtil();
	}
	
	public void test() throws IOException{
		//String httpOrgCreateTest = url + "page/login/loginreg.jsp";
		//String httpOrgCreateTest = url + "login.do;";
		String httpOrgCreateTest = url ;
		//String httpOrgCreateTest = url;
		Map<String,String> createMap = new HashMap<String,String>();
		createMap.put("username","jonney_zh");
		createMap.put("password","ml520zl");
		createMap.put("_@IMGRC@_","8hk6qk");
		createMap.put("method","login");
		createMap.put("date","1463573916280");
	//	createMap.put("org.apache.struts.taglib.html.TOKEN","fcf25637ba9d9e3bec6d9f129671bb6d&method=login&date=1463376456608&loginname=jonney_zh&password=ml520zl&_%40IMGRC%40_=eh86c5");
		createMap.put("org.apache.struts.taglib.html.TOKEN","21ec827f1b88d6800098e4cae7637492");
		
//		createMap.put("password","ml520zl");
//		createMap.put("_@IMGRC@_","hxarbb");
		
		String httpOrgCreateTestRtn = httpClientUtil.doPost_2(httpOrgCreateTest,createMap,charset);
		//String httpOrgCreateTestRtn_1 = httpClientUtil.doPost_1(httpOrgCreateTest,createMap);
		if(httpOrgCreateTestRtn==null){
			System.out.println("the result is null");
		}
		System.out.println("result:"+httpOrgCreateTestRtn);
	}
	
	
	public void test_1() throws IOException{

		//String result =new HttpClientUtil_2().doGet("https://ipcrs.pbccrc.org.cn/login.do?method=initLogin", charset);
		//String result =new HttpClientUtil_2().doGet("https://ipcrs.pbccrc.org.cn/page/login/loginreg.jsp", charset);
		//String result =new HttpClientUtil_2().doGet("https://ipcrs.pbccrc.org.cn", charset);
		BasicCookieStore result =new HttpClientUtil_2().getCookies("https://ipcrs.pbccrc.org.cn/page/login/loginreg.jsp", null,charset);
		if(result==null){
			System.out.println("the result is null");
		}
		System.out.println("result:"+result);
		for(Cookie cookie:result.getCookies()){
			System.out.println("the cookie name is "+cookie.getName()+"  and the value is "+cookie.getValue());
			
		}

	}

static String getUnicode(String s) {
        try {
            StringBuffer out = new StringBuffer("");
            byte[] bytes = s.getBytes("unicode");
            for (int i = 0; i < bytes.length - 1; i += 2) {
                //out.append("\\u");
                String str = Integer.toHexString(bytes[i + 1] & 0xff);
                for (int j = str.length(); j < 2; j++) {
                    out.append("0");
                }
                String str1 = Integer.toHexString(bytes[i] & 0xff);
                out.append(str1);
                out.append(str);
                 
            }
            return out.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
	
	public static void main(String[] args) throws IOException{
	}
}