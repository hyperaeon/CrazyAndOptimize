package com.credit.parse;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

public class HttpClientsTest {

	private String url = "https://ipcrs.pbccrc.org.cn/";
	private String charset = "utf-8";
	private HttpClientUtil httpClientUtil = null;

	private String request = "login.do?method=initLogin";

	public void init() {
		httpClientUtil = new HttpClientUtil();
	}

	public String test() throws Exception {
		String doRequest = url + request;
		HttpGet httpGet = new HttpGet(doRequest);
		HttpClient httpClient = new SSLClient();
		HttpResponse response = httpClient.execute(httpGet);
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

	public static void main(String[] args) throws Exception {
		HttpClientsTest test = new HttpClientsTest();
		System.out.println(test.test());
	}
}
