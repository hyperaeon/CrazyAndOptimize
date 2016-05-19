package com.credit.http;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

public class HttpClientsTest {

//	private String url = "https://ipcrs.pbccrc.org.cn/";
	private String charset = "utf-8";

//	private String url = "https://ipcrs.pbccrc.org.cn/page/login/loginreg.jsp";
	
	private String url = "https://ipcrs.pbccrc.org.cn/userReg.do";
    
	private String request = "login.do?method=initLogin";


	public String test() throws Exception {
		HttpClientUtil httpClientUtil = new HttpClientUtil();
		String httpOrgCreateTest = url;  
        Map<String,String> createMap = new HashMap<String,String>();  
//        createMap.put("authuser","*****");  
//        createMap.put("authpass","*****");  
//        createMap.put("orgkey","****");  
//        createMap.put("orgname","****");
        createMap.put("org.apache.struts.taglib.html.TOKEN","17ad790e0615ba19bfa406a80a81b3b1");
        createMap.put("method","initReg");
        String httpOrgCreateTestRtn = httpClientUtil.doPost(httpOrgCreateTest,createMap,charset);  
        System.out.println("result:"+httpOrgCreateTestRtn); 
        
        
		String doRequest = url;
		HttpGet httpGet = new HttpGet(doRequest);
		HttpPost httpPost = new  HttpPost(doRequest);
		HttpClient httpClient = new SSLClient();
		HttpResponse response = httpClient.execute(httpPost);
		HttpParams param = httpClient.getParams();
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
	
	private void test2() throws Exception {
		HttpClient httpClient = new SSLClient();
		HttpGet get = new HttpGet("http://www.zhihu.com/");
		HttpResponse response = httpClient.execute(get);
		String result = null;
		if(response != null){
            HttpEntity resEntity = response.getEntity();  
            if(resEntity != null){  
                result = EntityUtils.toString(resEntity,charset); 
            }
        }
		System.out.println(result);
	}

	public static void main(String[] args) throws Exception {
		HttpClientsTest test = new HttpClientsTest();
		System.out.println(test.test());
//		test.test2();
	}
}
