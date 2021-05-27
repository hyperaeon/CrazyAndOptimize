//package com.credit.http;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//
//import org.apache.http.Header;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.message.BasicHeader;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.util.EntityUtils;
//
//public class HttpClientUtil {
//
//	private String charset = "utf-8";
//
//	public String doPost(String url,Map<String,String> map, String cookie){
//        HttpClient httpClient = null;
//        HttpPost httpPost = null;
//        String result = null;
//        try{
//            httpClient = new SSLClient();
//            httpPost = new HttpPost(url);
//            //设置参数
//            List<NameValuePair> list = new ArrayList<NameValuePair>();
//            Iterator iterator = map.entrySet().iterator();
//            while(iterator.hasNext()){
//                Entry<String,String> elem = (Entry<String, String>) iterator.next();
//                list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));
//            }
//            if(list.size() > 0){
//                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,charset);
//                httpPost.setEntity(entity);
//            }
//            //设置设置Header
//            httpPost.addHeader(new BasicHeader("Cookie", cookie));
//            setOtherHeader(httpPost);
//            HttpResponse response = httpClient.execute(httpPost);
//            if(response != null){
//                HttpEntity resEntity = response.getEntity();
//                if(resEntity != null){
//                    result = EntityUtils.toString(resEntity,charset);
//                }
//            }
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//        return result;
//    }
//
//	/**
//	 * 设置请求Header
//	 * @param httpPost
//	 */
//	private void setOtherHeader(HttpPost httpPost) {
//		httpPost.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
//		httpPost.addHeader("Accept-Encoding", "gzip, deflate");
//		httpPost.addHeader("Accept-Language", "zh-CN,zh;q=0.8");
//
//		httpPost.addHeader("Cache-Control", "max-age=0");
//		httpPost.addHeader("Connection", "keep-alive");
//		httpPost.addHeader("Host", "ipcrs.pbccrc.org.cn");
//		httpPost.addHeader("Origin", "https://ipcrs.pbccrc.org.cn");
//		httpPost.addHeader("Referer", "https://ipcrs.pbccrc.org.cn/page/login/loginreg.jsp");
//		httpPost.addHeader("Upgrade-Insecure-Requests", "1");
//		httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36");
//
//		//上传流的请求头
//		httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
////		httpPost.addHeader("Content-Length", "83");
//	}
//
//}
