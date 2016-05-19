package com.credit.http;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;

public class HttpClientsTest {

//	private String url = "https://ipcrs.pbccrc.org.cn/";
	private String charset = "utf-8";

//	private String url = "https://ipcrs.pbccrc.org.cn/page/login/loginreg.jsp";
	
//	private String url = "https://ipcrs.pbccrc.org.cn/userReg.do";
    
	private String url = "https://ipcrs.pbccrc.org.cn/imgrc.do?a='" + new Date().getTime();

	private static Header[] headers = null;

	private static List<String> cookieList = new ArrayList<String>();
	
	private static String cookie = "";
	
	public void test() throws Exception {
		HttpClientUtil httpClientUtil = new HttpClientUtil();
		String httpOrgCreateTest = url;  
        Map<String,String> createMap = new HashMap<String,String>();
//		createMap.put("username","jonney_zh");
//		createMap.put("password","ml520zl");
//		createMap.put("method","login");
//		
//		createMap.put("_@IMGRC@_","en9eg9");
//		createMap.put("date","1463641197575");
//		createMap.put("org.apache.struts.taglib.html.TOKEN","c330462f5369fc815c846b5e9485c33f");
        
//        createMap.put("method","initReg");
        createMap.put("org.apache.struts.taglib.html.TOKEN","26cc5591147b2d14ae3320bce2e0b283");
        String httpOrgCreateTestRtn = httpClientUtil.doPost(httpOrgCreateTest,createMap, cookie);  
        System.out.println("result:"+httpOrgCreateTestRtn); 
	}
	
	/**
	 * 获取首页的header信息，保存到headers中
	 * @throws Exception
	 */
	private void test2() throws Exception {
		HttpClient httpClient = new SSLClient();
		HttpGet get = new HttpGet("https://ipcrs.pbccrc.org.cn/page/login/loginreg.jsp");
		HttpResponse response = httpClient.execute(get);
		headers = response.getAllHeaders();
//		removeContentLength();
		extractAndReconstructCookies();
		String result = null;
		if(response != null){
            HttpEntity resEntity = response.getEntity();  
            if(resEntity != null){  
                result = EntityUtils.toString(resEntity,charset); 
            }
        }
//		System.out.println(result);
	}
	
	/**
	 * 从heaer中提取Cookie，放到cookies中
	 */
	private void extractAndReconstructCookies() {
		if (headers != null) {
			//提取Cookie
			for (Header header : headers) {
				if (header.getName().contains("Set-Cookie")) {
					cookieList.add(header.getValue().substring(0, header.getValue().indexOf(";") + 1));
				}
			}
			//重组Cookie
			StringBuilder resultCookie = new StringBuilder();
			resultCookie.append(cookieList.get(2));
			resultCookie.append(cookieList.get(3));
			resultCookie.append("_gscu_1241536983=631254300v6nyy11;");
			resultCookie.append("_gscbrs_1241536983=1;");
			resultCookie.append(cookieList.get(1));
			resultCookie.append(cookieList.get(0));
			resultCookie.append(cookieList.get(4));
			cookie = resultCookie.toString();
			System.out.println("cookies after rebuild: " + cookie);
		}
	}

	private String test3() throws Exception {
		HttpPost httpPost = new  HttpPost(url);
		HttpClient httpClient = new SSLClient();
		HttpResponse response = httpClient.execute(httpPost);
		String result = null;
		if(response != null){
            HttpEntity resEntity = response.getEntity();  
            if(resEntity != null){  
                result = EntityUtils.toString(resEntity,charset); 
                return result;
            }  
        }
		return result; 
	}

	
	/**
	 * 移除Headers中的ContentLength
	 */
	private void removeContentLength() {
		Header[] headers2 = new Header[headers.length - 1];
		if (headers != null) {
			int i = 0;
			for (Header header : headers) {
				if (!header.getName().contains("Content-Length")) {
					headers2[i] = header;
					i ++;
				}
			}
			headers = headers2;
		}
	}

	public static void main(String[] args) throws Exception {
		HttpClientsTest test = new HttpClientsTest();
		test.test2();
		test.test();
	}
}
