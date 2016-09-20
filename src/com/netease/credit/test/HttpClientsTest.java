package com.netease.credit.test;

import java.io.UnsupportedEncodingException;
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

import com.netease.util.ParsePageUtil;


public class HttpClientsTest {

	private String charset = "GBK";

	private String loginUrl = "https://ipcrs.pbccrc.org.cn/page/login/loginreg.jsp";
	
	private String regUrl = "https://ipcrs.pbccrc.org.cn/userReg.do";
    
	private String imageUrl = "https://ipcrs.pbccrc.org.cn/imgrc.do?a=" + new Date().getTime();

	private static Header[] headers = null;

	private static List<String> cookieList = new ArrayList<String>();
	
	private static String cookie = "";
	
	private static final String TOKEN_NAME = "org.apache.struts.taglib.html.TOKEN";
	
	private static final String METHOD = "method";
	
	private static Map<String, String> inputNameValue = new HashMap<String, String>();//存放inpu中的name和value
	
	/**
	 * 模拟登录，存放cookie和请求的参数
	 * @throws Exception
	 */
	public void loginTest() throws Exception {
		HttpClientUtil3 httpClientUtil = new HttpClientUtil3();

		

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
        String httpOrgCreateTestRtn = httpClientUtil.doPost(loginUrl,createMap, cookie);  
//        System.out.println("result:"+httpOrgCreateTestRtn); 
	}
	
	/**
	 * 获取注册页面
	 */
	public void getUserRegPage() {
		HttpClientUtil3 httpClientUtil = new HttpClientUtil3();
        Map<String,String> createMap = new HashMap<String,String>();
        createMap.put("method", "initReg");
        String regPage = httpClientUtil.doPost(regUrl,createMap, cookie);
        System.out.println("regPage result:" + regPage);
        inputNameValue = ParsePageUtil.parseInput(regPage);
        //获取注册页面的验证码
        String imageResult = httpClientUtil.downloadImage(imageUrl,createMap, cookie);  
        System.out.println("imageResult result:" + imageResult);
	}
	
	/**
	 * 注册第一步：：填写身份信息
	 * @throws UnsupportedEncodingException 
	 */
	public void inputBasicInfo() throws UnsupportedEncodingException {
		HttpClientUtil3 httpClientUtil = new HttpClientUtil3();
        Map<String,String> createMap = new HashMap<String,String>();
        createMap.put(TOKEN_NAME, inputNameValue.get(TOKEN_NAME));//必须传正确的值，否则返回302 Moved Temporarily
        createMap.put(METHOD, inputNameValue.get(METHOD));//点击下一步触发的方法
        createMap.put("userInfoVO.name", "常晓茹");//姓名
        createMap.put("userInfoVO.certType", "0");//证件类型
        createMap.put("userInfoVO.certNo", "141122199305240088");//证件号码
        createMap.put("_@IMGRC@_", "sigsvj");//验证码
        createMap.put("1", "on");//勾选“我已阅读并同意”
        String inputResponsePage = httpClientUtil.doPost(regUrl,createMap, cookie);
        System.out.println("inputResponsePage result:" + inputResponsePage);
        inputNameValue = ParsePageUtil.parseInput(inputResponsePage);
	}
	
	/**
	 * 注册第二步：补充用户信息
	 * @throws UnsupportedEncodingException 
	 */
	public void postSecondReg() throws UnsupportedEncodingException {
		String phoneNumber = "134296757322";
		HttpClientUtil3 httpClientUtil = new HttpClientUtil3();
        Map<String,String> createMap = new HashMap<String,String>();
        createMap.put(TOKEN_NAME, inputNameValue.get(TOKEN_NAME));//必须传正确的值，否则返回302 Moved Temporarily
        createMap.put(METHOD, inputNameValue.get(METHOD));//点击提交触发的方法
        createMap.put("userInfoVO.loginName", "testAcount");//登录名
        createMap.put("userInfoVO.password", "liuliming321");//密码
        createMap.put("userInfoVO.confirmpassword", "liuliming321");//确认密码
        createMap.put("userInfoVO.email", "");//电子邮箱
        createMap.put("userInfoVO.mobileTel", phoneNumber);//手机号码
        createMap.put("tcId", getDynamicCode(phoneNumber));//动态码，在隐藏域中，由ajax请求获取
        
        createMap.put("counttime", "2");//获取动态码时的倒计时，不能低于2
        
        createMap.put("userInfoVO.verifyCode", "");//显示填写的动态码
        String postSecondRegPage = httpClientUtil.doPost(regUrl,createMap, cookie);
        System.out.println("postSecondRegPage result:" + postSecondRegPage);
	}
	
	/**
	 * 获取时后台返回的数字，如"97870404"
	 */
	public String getDynamicCode(String phoneNumber) {
		HttpClientUtil3 httpClientUtil = new HttpClientUtil3();
		Map<String, String> inputMap = new HashMap<String, String>();
		inputMap.put("method", "getAcvitaveCode");//请求方法
		inputMap.put("mobileTel", phoneNumber);//手机号码
		String getDynamicCodePage = httpClientUtil.doAjaxPost(regUrl,inputMap, cookie);
        System.out.println("getDynamicCodePage result:" + getDynamicCodePage);
        return getDynamicCodePage;
	}
	
	/**
	 * 获取首页的header信息，保存到headers中
	 * @throws Exception
	 */
	private void getLoginReg() throws Exception {
		HttpClient httpClient = new SSLClient();
//		org.apache.commons.httpclient.HttpClient httpClient = new org.apache.commons.httpclient.HttpClient();
//		httpClient.getHostConfiguration().setProxy("127.0.0.1", 8888);
//		httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, charset);
//		GetMethod postMethod = new GetMethod(loginUrl);
		//设置代理让fiddler2抓取
//		HttpHost proxy = new HttpHost("127.0.0.1", 8888);
//		httpClient.getParams().setParameter(ConnRouteParams.DEFAULT_PROXY, proxy);
		
		HttpGet get = new HttpGet(loginUrl);
		HttpResponse response = httpClient.execute(get);
		headers = response.getAllHeaders();
		extractAndReconstructCookies();
		String result = null;
		if(response != null){
            HttpEntity resEntity = response.getEntity();  
            if(resEntity != null){  
                result = EntityUtils.toString(resEntity,charset); 
            }
        }
		System.out.println(result);
	}
	
	public void downloadImage() throws Exception {
		HttpClientUtil3 httpClientUtil = new HttpClientUtil3();
        Map<String,String> createMap = new HashMap<String,String>();
        String httpOrgCreateTestRtn = httpClientUtil.downloadImage(imageUrl,createMap, cookie);  
        System.out.println("result:"+httpOrgCreateTestRtn); 
	}
	
	/**
	 * 从header中提取Cookie，放到cookies中
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
		HttpPost httpPost = new  HttpPost(loginUrl);
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

	
	public static void main(String[] args) throws Exception {
		HttpClientsTest test = new HttpClientsTest();
		test.getLoginReg();
		test.getUserRegPage();
		test.inputBasicInfo();
		test.postSecondReg();
//		test.loginTest();
	}
}
