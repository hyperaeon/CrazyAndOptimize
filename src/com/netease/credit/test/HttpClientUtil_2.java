package com.netease.credit.test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


/**
 * 
 * @ClassName: HttpClientUtil
 * @Description:利用HttpClient进行post请求的工具类 
 * @author:JonneyZhang
 * @date: 2016年5月17日 上午10:22:09
 */
public class HttpClientUtil_2 {
	

	public String doPost(String url,Map<String,String> map,String charset){
		SSLClient httpClient = null;
		HttpPost httpPost = null;
		String result = null;
		try{
			httpClient = new SSLClient();
			httpPost = new HttpPost(url);
			//设置参数
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			Iterator iterator = map.entrySet().iterator();
			while(iterator.hasNext()){
				Entry<String,String> elem = (Entry<String, String>) iterator.next();
				list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));
			}
			if(list.size() > 0){
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,charset);
				httpPost.setEntity(entity);
			}
			HttpResponse response = httpClient.execute(httpPost);
			if(response != null){
				HttpEntity resEntity = response.getEntity();
				if(resEntity != null){
					result = EntityUtils.toString(resEntity,charset);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return result;
	}
	
	public String doGet(String url,String charset){
		SSLClient httpClient = null;
		HttpGet httpGet = null;
		String result = null;
		try{
			httpClient = new SSLClient();
			httpGet = new HttpGet(url);
			HttpResponse response = httpClient.execute(httpGet);
			if(response != null){
				HttpEntity resEntity = response.getEntity();
				if(resEntity != null){
					result = EntityUtils.toString(resEntity,charset);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return result;
	}
  
	  	  	
		public String doPost_3(String url,Map<String,String> map,String charset){
			SSLClient httpClient = null;
			HttpPost httpPost = null;
			String result = null;
			
			BasicCookieStore cookieStore = new BasicCookieStore();
			   // 新建Cookies
		    BasicClientCookie secure_cookie = new BasicClientCookie("Secure","");
		    BasicClientCookie JSESSIONID_cookie = new BasicClientCookie("JSESSIONID","h0p5X8sfpyV0hJ1NT5HhXjYfKxQ4rgQ6G6kMV6YhvRryYmBLYHrD!-2096270977");
		    BasicClientCookie isBIGipServerpool_ipcrs_app_cookie = new BasicClientCookie("isBIGipServerpool_ipcrs_app","K+VHkHmZc3asam+FxRjkQ/ItLb4uVBElGCj0TOqiX1Ixxw+t44lTUF3OFY/7thRT4KaWSc/JEQbPSC+yAYq1VcxOj+Yd5Nb3ZhT3ihYpw6Ctw8TN8Lr8xtNzxI6OUduApXZzGhiGJb76IhpP5bivUgIZIx5yTA==");
		    BasicClientCookie isBIGipServerpool_ipcrs_web_cookie = new BasicClientCookie("isBIGipServerpool_ipcrs_web","nZa83NSTOBt2kIaFxRjkQ/ItLb4uVBQsT4J1I/jPt/L3ixnpSVncQiEtCI6Pe3uIMXgcq3cOmJWF");
		    BasicClientCookie TSf75e5b_cookie = new BasicClientCookie("TSf75e5b","7f503603370bfd0353c52b666833fae1dd5fa31b01935d87573c6bad");
		    
		    cookieStore.addCookie(secure_cookie);
		    cookieStore.addCookie(JSESSIONID_cookie);
		    cookieStore.addCookie(isBIGipServerpool_ipcrs_app_cookie);
		    cookieStore.addCookie(isBIGipServerpool_ipcrs_web_cookie);
		    cookieStore.addCookie(TSf75e5b_cookie);
			
			try{
				httpClient = new SSLClient();
				httpPost = new HttpPost(url);
				//设置参数
				List<NameValuePair> list = new ArrayList<NameValuePair>();
				Iterator iterator = map.entrySet().iterator();
				while(iterator.hasNext()){
					Entry<String,String> elem = (Entry<String, String>) iterator.next();
					list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));
				}
				if(list.size() > 0){
					UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,charset);
					httpPost.setEntity(entity);
				}
				
				httpClient.setCookieStore(cookieStore);
				HttpResponse response = httpClient.execute(httpPost);
				if(response != null){
					HttpEntity resEntity = response.getEntity();
					if(resEntity != null){
						result = EntityUtils.toString(resEntity,charset);
					}
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
			return result;
		}
		
		private String executeGet(final String https_url, final int port) {
		    String ret = "";
		    URL url;
		    try {
		        HttpsURLConnection con;
		        url = new URL(https_url);
		        con = (HttpsURLConnection) url.openConnection();       
		        con.setRequestMethod("GET"); 
		        con.setDoOutput(true); 
  	            DataOutputStream out = new DataOutputStream( con.getOutputStream()); 

  	            //获取输入流 
  	            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream())); 
  	            int code = con.getResponseCode(); 
  	            if (HttpsURLConnection.HTTP_OK == code){ 
  	                String temp = in.readLine(); 
  	                /*连接成一个字符串*/ 
  	                while (temp != null) { 
  	                    if (ret != null) 
  	                    	ret += temp; 
  	                    else 
  	                    	ret = temp; 
  	                    temp = in.readLine(); 
  	                } 
  	            }
		    } catch (MalformedURLException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		    return ret;
		}
		public BasicCookieStore getCookies(String url,Map<String,String> map,String charset){
	  		SSLClient httpClient = null;
			HttpPost httpPost = null;

			String result = null;
			String header_1;
			String header_2;
			String header_3;
			String header_4;
			String header_5;
			BasicCookieStore cookieStore = new BasicCookieStore();
			try{
				httpClient = new SSLClient();
				httpPost = new HttpPost(url);
 
//				//设置参数
//				List<NameValuePair> list = new ArrayList<NameValuePair>();
//				Iterator iterator = map.entrySet().iterator();
//				while(iterator.hasNext()){
//					Entry<String,String> elem = (Entry<String, String>) iterator.next();
//					list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));
//				}
//				if(list.size() > 0){
//					UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,charset);
//					httpPost.setEntity(entity);
//
//				}
				HttpResponse response = httpClient.execute(httpPost);
	
				httpClient.getCookieStore();
				
				header_1 =response.getHeaders("Set-Cookie")[0].getValue();
				header_2=response.getHeaders("Set-Cookie")[1].getValue();
				header_3=response.getHeaders("Set-Cookie")[2].getValue();
				header_4=response.getHeaders("Set-Cookie")[3].getValue();
				header_5=response.getHeaders("Set-Cookie")[4].getValue();

			    // 新建Cookies
			    BasicClientCookie secure_cookie = new BasicClientCookie("Secure","Secure");
			    BasicClientCookie JSESSIONID_cookie = new BasicClientCookie("JSESSIONID",header_2.split(";")[0].split("=")[0]);
			    BasicClientCookie isBIGipServerpool_ipcrs_app_cookie = new BasicClientCookie("isBIGipServerpool_ipcrs_app",header_3.split(";")[0].split("=")[0]);
			    BasicClientCookie isBIGipServerpool_ipcrs_web_cookie = new BasicClientCookie("isBIGipServerpool_ipcrs_web",header_4.split(";")[0].split("=")[0]);
			    BasicClientCookie TSf75e5b_cookie = new BasicClientCookie("TSf75e5b",header_5.split(";")[0].split("=")[0]);
			    
			    cookieStore.addCookie(secure_cookie);
			    cookieStore.addCookie(JSESSIONID_cookie);
			    cookieStore.addCookie(isBIGipServerpool_ipcrs_app_cookie);
			    cookieStore.addCookie(isBIGipServerpool_ipcrs_web_cookie);
			    cookieStore.addCookie(TSf75e5b_cookie);

			}catch(Exception ex){
				ex.printStackTrace();
			}
			return cookieStore;
		}     
	  	
}