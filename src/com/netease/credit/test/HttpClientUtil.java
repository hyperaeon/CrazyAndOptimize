package com.netease.credit.test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.sun.net.ssl.HttpsURLConnection;


/**
 * 
 * @ClassName: HttpClientUtil
 * @Description:利用HttpClient进行post请求的工具类 
 * @author:JonneyZhang
 * @date: 2016年5月17日 上午10:22:09
 */
public class HttpClientUtil {
	
	private static TrustManager myX509TrustManager = new X509TrustManager() { 

  	    @Override 
  	    public X509Certificate[] getAcceptedIssuers() { 
  	        return null; 
  	    }

		@Override
		public void checkClientTrusted(X509Certificate[] arg0, String arg1)
				throws java.security.cert.CertificateException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void checkServerTrusted(X509Certificate[] arg0, String arg1)
				throws java.security.cert.CertificateException {
			// TODO Auto-generated method stub
			
		} 

  	};
	
	public String doPost(String url,Map<String,String> map,String charset){
		HttpClient httpClient = null;
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
	
	     /*
	     2  urlString:访问的地址
	     3  nameValuePair:一个文件 包含登陆名密码
	     4  */
	      public  static  String doPost_1(String urlString, Map<String, String> nameValuePairs) throws IOException {
	         //发送请求
	         URL url=new URL(urlString);        
	         URLConnection connection=url.openConnection();
	         connection.setDoInput(true);
	         connection.setDoOutput(true);
	         connection.setRequestProperty("Host","ipcrs.pbccrc.org.cn");
	         connection.setRequestProperty("Connection","keep-alive");
	         connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");    
	         connection.connect();
	         //connection.setRequestProperty("Content-Length", "52");            
	             try(PrintWriter out=new PrintWriter(connection.getOutputStream())){
	                 boolean first=true;
	                for(Map.Entry<String, String> pair:nameValuePairs.entrySet()){
	                     if(first)first=false;
	                     else{ 
	                         out.print("&");
	                     }
	                     
	                     String name=pair.getKey().toString();
	                     String value=pair.getValue().toString();
	                     
	                     out.print(name);
	                     out.print('=');
	                     out.print(value);
	                 }    
	             }    
	         //获取请求成功后的JSESSIONID
	         String repex="\\;";
	         String JSESSIONID=null;
	         Pattern pattern=Pattern.compile(repex,Pattern.CASE_INSENSITIVE);
	         Map<String, List<String>> map=connection.getHeaderFields();
	          for(Map.Entry<String, List<String>> air:map.entrySet()){    
	             System.out.println(air.getKey()+":"+air.getValue().toString());
	             String s=":"+air.getKey();
	             System.out.println(s);
	             if(s.equals(":Set-Cookie")){                
	                 s=air.getValue().toString();
	                 Matcher matcher=pattern.matcher(s);
	                 matcher.find();
	                 int stat=matcher.start();
	                 int end=matcher.end();
	                 String match=s.substring(1,end-1);
	                 JSESSIONID=match;
	             }
	          }
	          //接受返回的信息
	         StringBuilder response=new StringBuilder();
	         try(Scanner in=new Scanner(connection.getInputStream())){
	             while(in.hasNextLine()){
	                 response.append(in.nextLine());
	                 response.append("\n");
	             }            
	         }catch (IOException e) {
	             // TODO: handle exception
	             if(!(connection instanceof HttpURLConnection)){
	                 InputStream err=((HttpURLConnection)connection).getErrorStream();
	                 if(err==null)throw e;
	                 Scanner in=new Scanner(err);
	                 response.append(in.nextLine());
	                 response.append("\n");
	             }
	         }
	         return response.toString();
	     }
	      
	      
	      
	  	public String doPost_2(String url,Map<String,String> map,String charset){
	  		SSLClient httpClient = null;
			HttpPost httpPost = null;
			HttpPost httpPost_1 = null;
			String result = null;
			String header_1;
			String header_2;
			String header_3;
			String header_4;
			String header_5;
			String result_header=null;
			try{
				httpClient = new SSLClient();
				httpPost = new HttpPost(url);
				httpPost_1 = new HttpPost("https://ipcrs.pbccrc.org.cn/login.do");  
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
					httpPost_1.setEntity(entity);
				}
				HttpResponse response = httpClient.execute(httpPost);
				//BufferHeader header_11=(BasicHeader) response.getHeaders("Set-Cookie");
				
				header_1 =response.getHeaders("Set-Cookie")[0].getValue();
				header_2=response.getHeaders("Set-Cookie")[1].getValue();
				header_3=response.getHeaders("Set-Cookie")[2].getValue();
				header_4=response.getHeaders("Set-Cookie")[3].getValue();
				header_5=response.getHeaders("Set-Cookie")[4].getValue();
//				httpClient.
				BasicCookieStore cookieStore = new BasicCookieStore();
			    // 新建一个Cookie
			    BasicClientCookie secure_cookie = new BasicClientCookie("Secure","Secure");
			    BasicClientCookie JSESSIONID_cookie = new BasicClientCookie("JSESSIONID",header_2.split(";")[0].split("=")[0]);
			    BasicClientCookie isBIGipServerpool_ipcrs_app_cookie = new BasicClientCookie("isBIGipServerpool_ipcrs_app",header_3.split(";")[0].split("=")[0]);
			    BasicClientCookie isBIGipServerpool_ipcrs_web_cookie = new BasicClientCookie("isBIGipServerpool_ipcrs_web",header_4.split(";")[0].split("=")[0]);
			    BasicClientCookie TSf75e5b_cookie = new BasicClientCookie("TSf75e5b",header_5.split(";")[0].split("=")[0]);
//			    secureCookie.setVersion(0);
//			    secureCookie.setDomain("ipcrs.pbccrc.org.cn");
//			    secureCookie.setPath("/");
			    // cookie.setAttribute(ClientCookie.VERSION_ATTR, "0");
			    // cookie.setAttribute(ClientCookie.DOMAIN_ATTR, "127.0.0.1");
			    // cookie.setAttribute(ClientCookie.PORT_ATTR, "8080");
			    // cookie.setAttribute(ClientCookie.PATH_ATTR, "/CwlProWeb");
			    
			    
//			    HttpPost httppost = new HttpPost(  
//		                "http://ipcrs.pbccrc.org.cn/login.do");  
			    
			    
			    cookieStore.addCookie(secure_cookie);
			    cookieStore.addCookie(JSESSIONID_cookie);
			    cookieStore.addCookie(isBIGipServerpool_ipcrs_app_cookie);
			    cookieStore.addCookie(isBIGipServerpool_ipcrs_web_cookie);
			    cookieStore.addCookie(TSf75e5b_cookie);
//				SchemeRegistry schemeRegistry = new SchemeRegistry(); 
//				schemeRegistry.register(new Scheme("https", 443, SSLSocketFactory.getSocketFactory())); 
//				PoolingClientConnectionManager cm = new PoolingClientConnectionManager(schemeRegistry); 
//				DefaultHttpClient client = new DefaultHttpClient(cm);	
//				client.setCookieStore(cookieStore);
//				HttpResponse response_backend=client.execute(httppost);
				
//				Header[] heads = response.getHeaders("Set-Cookie");
//				for(Header head : heads){
//					String name = head.getName();
//					if("BIGipServerpool_ipcrs_web".equals(name)){
//						String value = head.getValue();
//					}
//				}
				
//				 header_2=response.getHeaders("BIGipServerpool_ipcrs_web").toString();
//				 header_3=response.getHeaders("JSESSIONID").toString();
//				 header_4=response.getHeaders("TSf75e5b").toString();
				 result_header=" header_1 is "+header_1+"header-2 is "+header_2+"header-3 is"+header_3+"header-4 is"+header_4+" header-5 is  "+header_5+" end";
				 httpClient.setCookieStore(cookieStore);
				 HttpResponse response_1 = httpClient.execute(httpPost_1);
				 
				if(response_1 != null){
					HttpEntity resEntity = response_1.getEntity();
					if(resEntity != null){
						result = EntityUtils.toString(resEntity,charset);
					}
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
			//return result;
			return result_header;
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
		
		
	  	
	  	
	  	
	  	
	  	public String SendHttpsPOST(String url, List<NameValuePair> param, String data) { 
	  		String result = null; 
  	        
	  		
  	        //使用此工具可以将键值对编码成"Key=Value&amp;Key2=Value2&amp;Key3=Value3&rdquo;形式的请求参数 
  	        String requestParam = URLEncodedUtils.format(param, "UTF-8"); 
  	        try { 
  	            //设置SSLContext 
  	            SSLContext sslcontext = SSLContext.getInstance("TLS"); 
  	            sslcontext.init(null, new TrustManager[]{myX509TrustManager}, null);

  	            //打开连接
  	        //要发送的POST请求url?Key=Value&amp;Key2=Value2&amp;Key3=Value3的形式 
  	           URL requestUrl = new URL(url + "?" + requestParam); 
  	           HttpsURLConnection httpsConn = (HttpsURLConnection)requestUrl.openConnection();
  	           	
  	            //设置套接工厂 
  	            httpsConn.setSSLSocketFactory(sslcontext.getSocketFactory());
  	            httpsConn.setRequestProperty("Cookie", "xxx");
  	            
  	            //加入数据 
  	            httpsConn.setRequestMethod("POST"); 
  	            httpsConn.setDoOutput(true); 
  	            DataOutputStream out = new DataOutputStream( 
  	                    httpsConn.getOutputStream()); 
  	            if (data != null) 
  	                out.writeBytes(data); 
  	            
  	            out.flush(); 
  	            out.close();

  	            //获取输入流 
  	            BufferedReader in = new BufferedReader(new InputStreamReader(httpsConn.getInputStream())); 
  	            int code = httpsConn.getResponseCode(); 
  	            if (HttpsURLConnection.HTTP_OK == code){ 
  	                String temp = in.readLine(); 
  	                /*连接成一个字符串*/ 
  	                while (temp != null) { 
  	                    if (result != null) 
  	                        result += temp; 
  	                    else 
  	                        result = temp; 
  	                    temp = in.readLine(); 
  	                } 
  	            } 
  	        } catch (KeyManagementException e) { 
  	            e.printStackTrace(); 
  	        } catch (NoSuchAlgorithmException e) { 
  	            e.printStackTrace(); 
  	        } catch (MalformedURLException e) { 
  	            e.printStackTrace(); 
  	        } catch (ProtocolException e) { 
  	            e.printStackTrace(); 
  	        } catch (IOException e) { 
  	            e.printStackTrace(); 
  	        }

  	        return result;     
	  	}
}