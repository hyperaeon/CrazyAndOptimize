package com.netease.service;

import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.netease.util.ConstantUtil;
import com.netease.util.HttpClientUtil;
import com.netease.util.ParsePageUtil;
import com.netease.util.SSLClient;
import com.netease.vo.UserInfoVO;


/**
 * 注册服务
 * @author hzliyong
 *
 */
@Service
public class RegisterFlowService {

	private static Logger logger = LoggerFactory.getLogger(RegisterFlowService.class);
    
	private String imageUrl = "https://ipcrs.pbccrc.org.cn/imgrc.do?a=";

	private String checkLoginNameUrl = "https://ipcrs.pbccrc.org.cn/userReg.do?num=" + Math.random();//ajax检查用户名是否存在的url
	
	private static Header[] headers = null;

	private static List<String> cookieList = new ArrayList<String>();
	
	private static String cookie = "";
	
	private static Map<String, String> inputNameValue = new HashMap<String, String>();//存放inpu中的name和value

	private static String tcId;//点击动态码时返回的8位数字

	
	/**
	 * 获取首页的header信息，保存到headers中
	 * @throws Exception
	 */
	private void getLoginReg() {
		logger.info("getLoginReg");
		HttpClient httpClient;
		HttpGet get = new HttpGet(ConstantUtil.LOGIN_URL);
		HttpResponse response;
		try {
			httpClient = new SSLClient();
			response = httpClient.execute(get);
			headers = response.getAllHeaders();//获取响应部分的所有header
		} catch (Exception e) {
			logger.error("getLoginReg()方法获取首页header信息失败", e);
		}
		extractAndReconstructCookies();
	}
	
	/**
	 * 获取注册页面
	 */
	private void getUserRegPage() {
		logger.info("getUserRegPage");
        Map<String,String> paramMap = new HashMap<String,String>();
        paramMap.put(ConstantUtil.METHOD, ConstantUtil.INIT_REG);
        String regPage = HttpClientUtil.doPost(ConstantUtil.REGURL, paramMap, cookie);
        inputNameValue = ParsePageUtil.parseInput(regPage);
	}
	
	/**
	 * 获取验证码
	 * @throws Exception
	 */
	public BufferedImage getDynamicImg() throws Exception {
		String time =  String.valueOf(new Date().getTime());
		logger.info("getDynamicImg");
		HttpClientUtil httpClientUtil = new HttpClientUtil();
        Map<String,String> createMap = new HashMap<String,String>();
        return httpClientUtil.downloadImage(imageUrl + time,createMap, cookie); 
	}
	
	/**
	 * 初始化然后获取验证码
	 * @return
	 * @throws Exception 
	 */
	public BufferedImage initAndGetImg() throws Exception {
		logger.info("initAndGetImg");
		getLoginReg();
		getUserRegPage();
		return getDynamicImg();
	}
	
	/**
	 * 注册第一步：填写身份信息
	 * @throws UnsupportedEncodingException 
	 */
	public String inputBasicInfo(UserInfoVO userInfoVO) throws UnsupportedEncodingException {
        Map<String,String> paramMap = new HashMap<String,String>();
        paramMap.put(ConstantUtil.TOKEN_NAME, inputNameValue.get(ConstantUtil.TOKEN_NAME));//必须传正确的值，否则返回302 Moved Temporarily
        paramMap.put(ConstantUtil.METHOD, inputNameValue.get(ConstantUtil.METHOD));//点击下一步触发的方法
        paramMap.put(ConstantUtil.USER_NAME, userInfoVO.getName());//姓名
        paramMap.put(ConstantUtil.USER_CERT_TYPE, userInfoVO.getCertType());//证件类型
        paramMap.put(ConstantUtil.USER_CERTNO, userInfoVO.getCertNo());//证件号码
        paramMap.put(ConstantUtil.IDENTIFYING_CODE, userInfoVO.getCheckCode());//验证码
        paramMap.put(ConstantUtil.PROTOCOL, userInfoVO.getCheckAgreement());//勾选“我已阅读并同意”
        String inputResponsePage = HttpClientUtil.doPost(ConstantUtil.REGURL, paramMap, cookie);
        inputNameValue = ParsePageUtil.parseInput(inputResponsePage);//解析补充用户信息页面中的input标签
        return ParsePageUtil.parseErrorField(inputResponsePage);
	}
	
	/**
	 * 注册第二步：检查用户名是否已经存在的ajax请求，返回1表示用户名已经被使用，返回0表示可以使用
	 * @return
	 */
	public String checkRegLoginnameHasUsed(UserInfoVO userInfoVO) {
		Map<String,String> paramMap = new HashMap<String,String>();
        paramMap.put(ConstantUtil.TOKEN_NAME, inputNameValue.get(ConstantUtil.TOKEN_NAME));//必须传正确的值，否则返回302 Moved Temporarily
        paramMap.put(ConstantUtil.METHOD, ConstantUtil.CHECK_REG_LOGINNAME_HASUSED);//点击提交触发的方法
        paramMap.put(ConstantUtil.USER_LOGIN_NAME, userInfoVO.getLoginName());//登录名
        return HttpClientUtil.doAjaxPost(checkLoginNameUrl, paramMap, cookie);
	}
	
	/**
	 * 注册第二步：补充用户信息
	 * @throws UnsupportedEncodingException 
	 */
	public String postSecondReg(UserInfoVO userInfoVO) throws UnsupportedEncodingException {
        Map<String,String> paramMap = new HashMap<String,String>();
        paramMap.put(ConstantUtil.TOKEN_NAME, inputNameValue.get(ConstantUtil.TOKEN_NAME));//必须传正确的值，否则返回302 Moved Temporarily
        paramMap.put(ConstantUtil.METHOD, inputNameValue.get(ConstantUtil.METHOD));//点击提交触发的方法
        paramMap.put(ConstantUtil.USER_LOGIN_NAME, userInfoVO.getLoginName());//登录名
        paramMap.put(ConstantUtil.USER_LOGIN_PASSWORD, userInfoVO.getPassword());//密码
        paramMap.put(ConstantUtil.USER_LOGIN_COMFIRM_PASSWORD, userInfoVO.getConfirmPassword());//确认密码
        paramMap.put(ConstantUtil.USER_EMAIL, userInfoVO.getEmail());//电子邮箱
        paramMap.put(ConstantUtil.USER_MOBILE, userInfoVO.getMobileTel());//手机号码
        paramMap.put(ConstantUtil.TCID, userInfoVO.getTcId());//动态码，在隐藏域中，由ajax请求获取
        paramMap.put(ConstantUtil.COUNTTIME, userInfoVO.getCounttime());//获取动态码时的倒计时，不能低于2
        paramMap.put(ConstantUtil.USER_VERIFY_CODE, userInfoVO.getVerifyCode());//显示填写的动态码
        String postSecondRegPage = HttpClientUtil.doPost(ConstantUtil.REGURL, paramMap, cookie);
        inputNameValue = ParsePageUtil.parseInput(postSecondRegPage);
        if (isMovedTemporarily(postSecondRegPage)) {//如果为302 Moved Temporarily则返回302
        	return ConstantUtil.TEMPORARILY_MOVED_CODE;
        }
        return ParsePageUtil.parseErrorField(postSecondRegPage);
	}
	
	/**
	 * 判断返回页面是否为302  Moved Temporarily
	 * @param postSecondRegPage
	 * @return
	 */
	private boolean isMovedTemporarily(String postSecondRegPage) {
		if (!StringUtils.isEmpty(postSecondRegPage) && postSecondRegPage.contains("302")) {
			return true;
		}
		return false;
	}

	/**
	 * 通过手机号码获取验证码
	 * 获取时后台返回的数字，如"97870404"
	 */
	public String getDynamicCode(String phoneNumber) {
		Map<String, String> inputMap = new HashMap<String, String>();
		inputMap.put(ConstantUtil.METHOD, ConstantUtil.GET_ACTIVITAVE_CODE);//请求方法
		inputMap.put(ConstantUtil.MOBILE, phoneNumber);//手机号码
        return HttpClientUtil.doAjaxPost(ConstantUtil.REGURL,inputMap, cookie);
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
		}
	}
	
	public static void main(String[] args) throws Exception {
		RegisterFlowService registerFlow = new RegisterFlowService();
		registerFlow.getLoginReg();
		registerFlow.getUserRegPage();
		
		//注册第一步需要填写的信息;
		UserInfoVO userInfoVO = new UserInfoVO();
		userInfoVO.setName("王恒沙");
		userInfoVO.setCertNo("110108198102133428");
		userInfoVO.setCheckCode("sigsvj");
		String errorMessage = registerFlow.inputBasicInfo(userInfoVO);
		
		//获取动态码
		String phoneNumber = "13449375755";
		tcId = registerFlow.getDynamicCode(phoneNumber);
		
		//注册第二部需要填写的信息
		UserInfoVO userInfoVO2 = new UserInfoVO();
		userInfoVO2.setLoginName("super");
		userInfoVO2.setPassword("abcd321");
		userInfoVO2.setConfirmPassword("abcd321");
		userInfoVO2.setEmail("");
		userInfoVO2.setMobileTel(phoneNumber);
		userInfoVO2.setTcId(tcId);
		userInfoVO2.setCounttime("2");
		userInfoVO2.setVerifyCode("");
		String postError = registerFlow.postSecondReg(userInfoVO2);
	}
}
