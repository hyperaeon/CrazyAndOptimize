package com.netease.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.netease.credit.test.SSLClient;
import com.netease.util.ConstantUtil;
import com.netease.util.HttpClientUtil;
import com.netease.util.ParsePageUtil;

/**
 * 
 * @ClassName: SecurityUpgradeService
 * @Description: 征信系统登陆模块设计到的所有服务
 * @author:JonneyZhang
 * @date: 2016年5月25日 下午1:47:30
 */
@Service
public class SecurityUpgradeService {
	
	final static Logger logger = LoggerFactory.getLogger(SecurityUpgradeService.class);

	private String charset = "utf-8";

	private String loginUrl = "https://ipcrs.pbccrc.org.cn/page/login/loginreg.jsp"; //get请求
	
	private String exectLoginUrl = "https://ipcrs.pbccrc.org.cn/login.do";//post请求
    
	private String imageUrl = "https://ipcrs.pbccrc.org.cn/imgrc.do?a=";//post
	
	private String newerUrl = "https://ipcrs.pbccrc.org.cn/setSafetyLevel.do?method=index&isnew=true";//get
	private String newerUrl_1 = "https://ipcrs.pbccrc.org.cn/setSafetyLevel.do";//post

	
	private static Header[] headers = null;

	private static List<String> cookieList = new ArrayList<String>();
	
	private static String cookie = "";
	
	private static Map<String, String> inputNameValue = new HashMap<String, String>();//存放inpu中的name和value
	
	/**
	 * 获取验证码
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	public void getVerifyCode() throws Exception {
		String time =  String.valueOf(new Date().getTime());
		HttpClientUtil httpClientUtil = new HttpClientUtil();
        Map<String,String> createMap = new HashMap<String,String>();
        createMap.put("org.apache.struts.taglib.html.TOKEN",inputNameValue.get(ConstantUtil.TOKEN_NAME));
        String httpOrgCreateRtn = httpClientUtil.downloadImage_3(imageUrl + time,createMap, cookie); 
        System.out.println("result:"+httpOrgCreateRtn); 
	}
	
	/**
	 * 登陆
	 * @throws Exception
	 */
	public void UserLogin(String username,String password,String code) throws Exception {
		HttpClientUtil httpClientUtil = new HttpClientUtil();
        Map<String,String> createMap = new HashMap<String,String>();
//		createMap.put("loginname","superDCH");
//		createMap.put("password","liuliming321");
		createMap.put("loginname",username);
		createMap.put("password",password);
		createMap.put("method","login");
		createMap.put("date","1463573916280");
		createMap.put("_@IMGRC@_",code);
        createMap.put("org.apache.struts.taglib.html.TOKEN",inputNameValue.get(ConstantUtil.TOKEN_NAME));
        String httpOrgCreateRtn = httpClientUtil.doPost_1(exectLoginUrl,createMap, cookie);  
       // logger.debug("the result of verifyCode is {} ",httpOrgCreateRtn);
        System.out.println("result:"+httpOrgCreateRtn); 
	}

	/**
	 * 获取首页的header信息，保存到headers中
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	public void initHeader() throws Exception {
		SSLClient httpClient = new SSLClient();
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
		inputNameValue = ParsePageUtil.parseInput(result);
		//logger.debug("the result of first request is {} ",result);
		System.out.println("result:"+result); 
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
			//logger.debug("cookies after rebuild: {}",cookie);
			System.out.println("result:"+cookie); 
		}
	}	
	
	/**
	 * 安全等级升级第一步
	 * @throws Exception
	 */
	@SuppressWarnings({ "unused", "static-access" })
	public void SecurityFirstStep() throws Exception {
		HttpClientUtil httpClientUtil = new HttpClientUtil();
	    Map<String,String> createMap = new HashMap<String,String>();
	    String result = httpClientUtil.doGet(newerUrl, cookie); 
	  //  logger.debug("新用户刚登陆需要确实安全升级下一步 :{} ",result);
	    System.out.println("result:"+result); 
	}
	
	//需要第2次确定一下
	public void SecuritySecondStep() throws Exception {
		HttpClientUtil httpClientUtil = new HttpClientUtil();
        Map<String,String> createMap = new HashMap<String,String>();

		createMap.put("method","setSafetyLevelStep2");
        String result = httpClientUtil.doPost_1(newerUrl_1,createMap, cookie);
        inputNameValue = ParsePageUtil.parseInput(result);
       // logger.debug("新用户刚登陆需要确实安全升级第二步 :{} ",result);
        System.out.println("result:"+result); 
	}
	
	//需要第3次确定一下
	public String SecurityThirdStep() throws Exception {
		HttpClientUtil httpClientUtil = new HttpClientUtil();
	    Map<String,String> createMap = new HashMap<String,String>();
		createMap.put("method","chooseCertify");
	    createMap.put("authtype","2");
	    createMap.put("org.apache.struts.taglib.html.TOKEN",inputNameValue.get(ConstantUtil.TOKEN_NAME));
	    String result = httpClientUtil.doPost_2(newerUrl_1,createMap, cookie);  
	    //logger.debug("新用户刚登陆需要确实安全升级第三步 :{} ",result);
	    System.out.println("result:"+result); 
	    return result;
		}
	
	//第四步，回答问题，通过安全校验
	public String SecurityFourthStep(Map<String,String> createMap) throws Exception {
		HttpClientUtil httpClientUtil = new HttpClientUtil();
	    Map<String,String> createMap1 = createMap;
	    String result = httpClientUtil.doPost_2(newerUrl_1,createMap1, cookie);  
	    //logger.debug("新用户刚登陆需要确实安全升级第三步 :{} ",result);
	    System.out.println("result:"+result); 
	    return result;
	}
	/*
	 * 升级征信等级所需要回答的问题
	 */
	public String getQuestionContent(String name,String password,String code) throws Exception {
		initHeader();
		getVerifyCode();
		UserLogin(name,password,code);
		SecurityFirstStep();
		SecuritySecondStep();
		String questionStr=SecurityThirdStep();
		return questionStr;
	}
	
	/**
	 * 测试用
	 * @param args
	 * @throws Exception
	 */
//	public static void main(String[] args) throws Exception {
//		SecurityUpgradeService securityUpgradeService = new SecurityUpgradeService();
//		securityUpgradeService.initHeader();
//		securityUpgradeService.getVerifyCode();
//		securityUpgradeService.UserLogin("","","");
//		securityUpgradeService.SecurityFirstStep();
//		securityUpgradeService.SecuritySecondStep();
//		String questionStr=securityUpgradeService.SecurityThirdStep();
//	}
	
}
