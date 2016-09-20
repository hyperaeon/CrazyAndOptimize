package com.netease.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreProtocolPNames;

//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;

public class SmsUtil {
	private static String Url = "http://106.ihuyi.com/webservice/sms.php?method=Submit";//发送短信用的服务器地址
	
	/**
	 * zhanglei
	 * 2016年6月13日14:03:03
	 * @param email
	 * @Functon 邮箱有效性验证
	 * @return
	 */
	public static boolean validateEmail(String email) {
		if (email == null || email.trim().equals("")) {
			return false;
		}
		String pat = "[a-zA-Z0-9_\\-\\.]+@[a-zA-Z0-9]+(\\.(com))";
		Pattern p = Pattern.compile(pat);
		Matcher match = p.matcher(email);
		return match.matches();
	}

	/**
	 * 
	 * <p>User: zhang lei
	 * <p>Date: 2016年6月13日14:03:09
	 * <p>Function:随即生成6位验证码
	 * <p>Version: 1.0
	 */
	
	public static int getRandomNum(){
		 Random r = new Random();
		 return r.nextInt(900000)+100000;//(Math.random()*(999999-100000)+100000)
	}
	
	/**
	 * 
	 * <p>User: zhang lei
	 * <p>Date: 2016年6月13日14:03:14
	 * <p>Function:手机号码合法性验证
	 * <p>Version: 1.0
	 */
	 public static boolean checkMobileNumber(String mobileNumber){
	  boolean flag = false;
	  try{
	    Pattern regex = Pattern.compile("^(((13[0-9])|(17[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$");
	    Matcher matcher = regex.matcher(mobileNumber);
	    flag = matcher.matches();
	   }catch(Exception e){
	    flag = false;
	   }
	  return flag;
	 }
	 
	 
	 /**
	  * 
	  * <p>User: zhang lei
	  * <p>Date: 2016-6-13 14:02:57
	  * <p>Function:给一个人发送单条短信
	  * <p>Version: 1.0
	  * <p>@param mobile 手机号
	  * <p>@param code  短信内容
	  */	
	 
		public static void sendSms1(String mobile,String code) throws UnsupportedEncodingException{
			HttpClient client = new DefaultHttpClient(); 
			HttpPost method = new HttpPost(Url); 
			client.getParams().setParameter(CoreProtocolPNames.HTTP_CONTENT_CHARSET, "UTF-8");
			method.setHeader("ContentType","application/x-www-form-urlencoded;charset=UTF-8");
		    String content = new String(code);  
		   // Properties property=new Properties();
		   // InputStream inputStream=ToolsUtil.class.getClassLoader().getResourceAsStream("/Sms.properties");
		   // InputStream inputStream=Thread.currentThread().getContextClassLoader().getResourceAsStream("/src/main/resource/global/Sms.properties");
//		    try {
//				property.load(inputStream);
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
	//	    String account = "cf_yongchuang", password = "123456";
		    String account = "cf_15957147566", password = "hznetease";
//		    account=property.getProperty("account");
//		    password=property.getProperty("password");
		    
		    System.out.println("account "+account);
		    System.out.println("password "+password);
		    
		    List<NameValuePair> formparams=new ArrayList<NameValuePair>();
		    formparams.add(new BasicNameValuePair("account",account));
		    formparams.add(new BasicNameValuePair("password", password));
		    formparams.add(new BasicNameValuePair("mobile", mobile));
		    formparams.add(new BasicNameValuePair("content", content));
		    formparams.add(new BasicNameValuePair("format", "json"));
		    
		    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");
			method.setEntity(entity);
			//ObjectMapper result=new ObjectMapper();
			String jsonString;
			//TypeReference<List<Map<String, String>>> typeReference = new TypeReference<List<Map<String, String>>>() {};
			try {
				HttpResponse response=client.execute(method);
				System.out.println("response code is "+response.getStatusLine().getStatusCode());
			
				if(response.getStatusLine().getStatusCode()==200){
					HttpEntity httpEntity=response.getEntity();
					System.out.println("enetity is "+httpEntity);
					if(httpEntity!=null){
						try {
							BufferedReader bufferedReader=new BufferedReader(
									new InputStreamReader(httpEntity.getContent(),"UTF-8"),8*1024
									);
							StringBuilder entityStringBuilder =new StringBuilder();
							String line=null;
							while((line=bufferedReader.readLine())!=null){
								entityStringBuilder.append(line);
							}
							List<Map<String, String>> list;
							String data[]=entityStringBuilder.toString().split(",");
							System.out.println("code is "+data[0].split(":")[1]);
							System.out.println("msg  is "+data[1].split(":")[1]);
							System.out.println("smsid  is "+data[2].split(":")[1]);							
						} catch (Exception e) {
							
						}
					}
				}			
			} catch (IOException e) {
				e.printStackTrace();
			} 				
		}
		
	 public static void main(String[] args) throws UnsupportedEncodingException{
//		 boolean check=checkMobileNumber("15957147566");
//          System.out.println(check);
          
  		sendSms1("13185080773","您的验证码是：77777。请不要把验证码泄露给其他人。");
//		 Properties  properties = new Properties();
//         InputStream input      = this.getClass().getResourceAsStream("/XmlDataSource.properties");
//         properties.load(input);
//
//         for (String key : properties.stringPropertyNames()) {
//             String value = properties.getProperty(key);
//
//             Map.Entry<String, String> pair = new AbstractMap.SimpleEntry<String, String>(key, value);
//             queue.put(pair);
//         }
  	 }
}
