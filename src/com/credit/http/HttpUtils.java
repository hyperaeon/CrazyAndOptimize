package com.credit.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.ip.constant.Constants;

public class HttpUtils {

	
	public static String httpGet(String url) throws Exception {
		HttpClient httpClient = null;
		HttpGet get = null;
		String result = null;
		try {
			httpClient = new DefaultHttpClient();
			get = new HttpGet(url);
			HttpResponse response = httpClient.execute(get);
			if(response != null){
				HttpEntity resEntity = response.getEntity();  
				if(resEntity != null){  
					result = EntityUtils.toString(resEntity, Constants.CHARSET); 
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (get != null) {
				get.abort();
			}
			if (httpClient != null) {
				httpClient.getConnectionManager().shutdown();
			}
		}
		return result;
	}
}
