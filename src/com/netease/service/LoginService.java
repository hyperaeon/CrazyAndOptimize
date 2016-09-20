package com.netease.service;

import java.awt.image.BufferedImage;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.netease.credit.test.SSLClient;
import com.netease.domain.User;
import com.netease.dto.QuestionPageDTO;
import com.netease.repositories.UserRepository;
import com.netease.util.ConstantUtil;
import com.netease.util.HttpClientUtil;
import com.netease.util.ParsePageUtil;

/**
 * 
 * @ClassName: LoginService
 * @Description: 征信系统登陆模块设计到的所有服务
 * @author:JonneyZhang
 * @date: 2016年5月23日 下午4:47:30
 */
@Service
public class LoginService {
	
	final static Logger logger = LoggerFactory.getLogger(LoginService.class);
	
	private String charset = "utf-8";
	private String loginUrl = "https://ipcrs.pbccrc.org.cn/page/login/loginreg.jsp"; //get请求
	private String exectLoginUrl = "https://ipcrs.pbccrc.org.cn/login.do";//post请求
	private String queryReportUrl = "https://ipcrs.pbccrc.org.cn/reportAction.do?method=queryReport"; //get请求 
	private String imageUrl = "https://ipcrs.pbccrc.org.cn/imgrc.do?a=";//post	
	private String getSimpleReportUrl = "https://ipcrs.pbccrc.org.cn/simpleReport.do";//post		
	private String questionAnswerUrl = "https://ipcrs.pbccrc.org.cn/setSafetyLevel.do";//post

	private static Header[] headers = null;

	private static List<String> cookieList = new ArrayList<String>();
	
	private static String cookie = "";
	
	private static Map<String, String> inputNameValue = new HashMap<String, String>();//存放inpu中的name和value
	
	@Autowired
	private UserRepository userRepository;
	
	public Map<String, String> getInputNameValue() {
		return inputNameValue;
	}
	
	
	/**
	 * 获取验证码
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	public void getDynamicImg() throws Exception {
		String time = String.valueOf(new Date().getTime());
		HttpClientUtil httpClientUtil = new HttpClientUtil();
        Map<String,String> createMap = new HashMap<String,String>();
        createMap.put("org.apache.struts.taglib.html.TOKEN","26cc5591147b2d14ae3320bce2e0b283");
        String httpOrgCreateTestRtn = httpClientUtil.downloadImage_3(imageUrl + time,createMap, cookie);  
	}
	
	
	/**
	 * 获取验证码
	 * @throws Exception
	 */
	public BufferedImage getDynamicImg_2() throws Exception {
		String time = String.valueOf(new Date().getTime());
		HttpClientUtil httpClientUtil = new HttpClientUtil();
        Map<String,String> createMap = new HashMap<String,String>();
        createMap.put("org.apache.struts.taglib.html.TOKEN","26cc5591147b2d14ae3320bce2e0b283");
        BufferedImage httpOrgCreateTestRtn = httpClientUtil.downloadImage(imageUrl + time,createMap, cookie);  
        logger.info("图片地址："+imageUrl);
		return httpOrgCreateTestRtn; 
	}
	
	
	
	/**
	 * 模拟登陆功能
	 * @param loginname :登陆名
	 * @param password ：密码
	 * @param date：时间戳
	 * @param mgrc：动态验证码
	 * @throws Exception
	 */
	public String exectLogin(String loginname,
						   String password,
						   String mgrc ) throws Exception {
		HttpClientUtil httpClientUtil = new HttpClientUtil();
        Map<String,String> createMap = new HashMap<String,String>();
		createMap.put("loginname",loginname);
		createMap.put("password",password);
		createMap.put("method","login");
		createMap.put("date","1463573916280");
		createMap.put("_@IMGRC@_",mgrc);
        createMap.put("org.apache.struts.taglib.html.TOKEN","26cc5591147b2d34ae3320bce2e0b383");
        String execlogin = httpClientUtil.doPost_0(exectLoginUrl,createMap, cookie);
        logger.debug("exec login result is {}",execlogin);
        return execlogin;
	}
	

	/**
	 * 获取报告
	 * @throws Exception
	 */
	public String queryReport() throws Exception {
		@SuppressWarnings("unused")
		HttpClientUtil httpClientUtil = new HttpClientUtil();
        String reportContent = HttpClientUtil.doGet(queryReportUrl, cookie); 
        logger.debug(" queryReport result is {}",reportContent);
        return reportContent;
	}
	
	/**
	 * 获取首页的header信息，保存到headers中
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	private void initHeader() throws Exception {
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
		 logger.debug(" loginregister result is {}",result);
	}
	
	/**
	 * 从heaer中提取Cookie，放到cookies中
	 */
	private void extractAndReconstructCookies() {
		if (headers != null) {
			//提取Cookie
			cookieList.clear();//先清空list，否则无法获取最新的cookie
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
			logger.info(cookie);
		    logger.debug(" cookies after rebuild: {}", cookie);
		}
	}

	/**
	 * 征信报告获取最后一步
	 * @param tradeCode 查询征信报告的所需的手机短号
	 * @throws Exception
	 */
	public String getViewReport(String tradeCode) throws Exception {
		HttpClientUtil httpClientUtil = new HttpClientUtil();
        Map<String,String> createMap = new HashMap<String,String>();

		createMap.put("method","viewReport");
		createMap.put("reportformat","21");
		createMap.put("tradeCode",tradeCode);
        String viewReport = httpClientUtil.doPost_1(getSimpleReportUrl,createMap, cookie); 
        logger.debug(" 征信报告明细如下: {}", viewReport);
        return viewReport;
	}
		
	/**
	 * 获取征信报告服务
	 * @param tradeCode 报告手机动态码
	 * @return
	 * @throws Exception
	 */
	public String getCreditContent(String tradeCode) throws Exception{

//		initHeader(); //初始化请求头信息
//		getDynamicImg(); //获取动态验证码
//		exectLogin(loginname,password,mgrc); //模拟执行登陆
		queryReport(); //跳转到征信报告查询页面
		String creditResult=getViewReport(tradeCode); //传入手机查询短信号，获取征信报告模板
		return creditResult;
	}
	
	
	public BufferedImage getImage() throws Exception{
	    initHeader(); //初始化请求头信息
		BufferedImage bi=getDynamicImg_2();
		return bi;
	}
	
	/**
	 * 点击【申请信用信息】所发的请求
	 * @return
	 */
	public String clickApplyingInfo() {
		HttpClientUtil httpClientUtil = new HttpClientUtil();
		Map<String,String> createMap = new HashMap<String,String>();
		createMap.put(ConstantUtil.METHOD, ConstantUtil.APPLICATION_REPORT);
        String reportContent = httpClientUtil.doPostRequest(ConstantUtil.APPLY_REPORTURL, createMap,
        		cookie);
//        inputNameValue = ParsePageUtil.parseInput(reportContent);
        logger.debug(" clickApplyingInfo result is {}",reportContent);
        return reportContent;
	}
	
	/**
	 * 根据“信息服务 > 申请信用信息”页面获取报告的状态。
	 * @return
	 */
	public String getReportStatus() {
		String responsePage = clickApplyingInfo();
		return ParsePageUtil.parseReportStatus(responsePage);
	}
	/**
	 * 获取报告的回答问题页面，先访问“信息服务 > 申请信用信息”，看返回的结果；
	 * 	1、如果是报告已经生成了，则访问重新获取问题url，否则进入步骤2
	 *  2、如果访问获取问题时返回“您的个人信用信息产品已存在，请点击"获取信用信息"查看。
	 *  	若继续申请查询，现有的个人信用信息产品将不再保留，是否继续？”，则表示报告已经生成了，需要访问重新获取问题url
	 * @return
	 */
	private String fetchQuestionPageBeforeGetReport() {
		HttpClientUtil httpClientUtil = new HttpClientUtil();
        Map<String,String> createMap = new HashMap<String,String>();
//        String status = getReportStatus();
//        createMap.put(ConstantUtil.METHOD, ConstantUtil.CHECK_ISHAS_REPORT);
        createMap.put(ConstantUtil.TOKEN_NAME, inputNameValue.get(ConstantUtil.TOKEN_NAME));
        createMap.put(ConstantUtil.AUTHTYPE,"2");
        createMap.put(ConstantUtil.APPLICATION_OPTION,"21");
        String httpOrgCreateTestRtn = "";
        createMap.put(ConstantUtil.METHOD, ConstantUtil.VERIFY);
    	httpOrgCreateTestRtn = httpClientUtil.doPostRequest(ConstantUtil.REFETCH_QUESTION_URL
    			, createMap, cookie);
//        if (status.equals(ConstantUtil.GENERATED)) {//如果报告已经生成了，还要重新获取，则访问ConstantUtil.REFETCH_QUESTION_URL
//        	createMap.put(ConstantUtil.METHOD, ConstantUtil.VERIFY);
//        	httpOrgCreateTestRtn = httpClientUtil.doPostRequest(ConstantUtil.REFETCH_QUESTION_URL
//        			, createMap, cookie);
//        } else {
//        	httpOrgCreateTestRtn = httpClientUtil.doPostRequest(ConstantUtil.QUESTION_BEFORE_GETREPORT,
//        			createMap, cookie);
//        	String message = ParsePageUtil.parseDivMessage(httpOrgCreateTestRtn);
//            if (message.contains(ConstantUtil.EXIST)) {//虽然验证未通过，但是可能之前申请的身份码还没有过期，这个时候其实报告也是已经生成了，所以要想重新获取问题，则需要发送一个新的请求
//            	createMap.put(ConstantUtil.METHOD, ConstantUtil.VERIFY);
//            	httpOrgCreateTestRtn = httpClientUtil.doPostRequest(ConstantUtil.REFETCH_QUESTION_URL
//            			, createMap, cookie);
//            }
//        }
        inputNameValue = ParsePageUtil.parseInput(httpOrgCreateTestRtn);
        logger.debug("   result is {}", httpOrgCreateTestRtn);
        return httpOrgCreateTestRtn;
	}
	
	/**
	 * 解析回答问题页面，返回map
	 * @param questionPage
	 * @return
	 */
	public Map<String, List<String>> extractQuestionPage() {
		String questionPage = fetchQuestionPageBeforeGetReport();
		return ParsePageUtil.extractQuestion(questionPage);
	}
	
	/**
	 * 提交回答问题
	 * @param pageDTO
	 * @return
	 */
	public String submitQuestionPage(QuestionPageDTO pageDTO, boolean flag) {
		HttpClientUtil httpClientUtil = new HttpClientUtil();
        Map<String,String> createMap = new HashMap<String,String>();
		createMap.put(ConstantUtil.METHOD, "");
		createMap.put(ConstantUtil.TOKEN_NAME, inputNameValue.get(ConstantUtil.TOKEN_NAME));
		createMap.put(ConstantUtil.AUTHTYPE,"2");
		createMap.put(ConstantUtil.APPLICATION_OPTION,"21");
		createMap.put("kbaList[0].answerresult", pageDTO.getAnswerResult0());
		createMap.put("kbaList[0].options", pageDTO.getAnswerResult0());
		createMap.put("kbaList[1].answerresult", pageDTO.getAnswerResult1());
		createMap.put("kbaList[1].options", pageDTO.getAnswerResult1());
		createMap.put("kbaList[2].answerresult", pageDTO.getAnswerResult2());
		createMap.put("kbaList[2].options", pageDTO.getAnswerResult2());
		createMap.put("kbaList[3].answerresult", pageDTO.getAnswerResult3());
		createMap.put("kbaList[3].options", pageDTO.getAnswerResult3());
		createMap.put("kbaList[4].answerresult", pageDTO.getAnswerResult4());
		createMap.put("kbaList[4].options", pageDTO.getAnswerResult4());
		buildSubmitQuestionParameter(createMap);
//        if (flag) {//报告已经生成，重新获取
//        	createMap.put(ConstantUtil.FLAG, ConstantUtil.TRUE);
//        } else {
//        	createMap.put(ConstantUtil.FLAG, ConstantUtil.FALSE);
//        }
        String  questionResponsePage = httpClientUtil.doPostRequest(ConstantUtil.SUBMIT_REPORT_QUESTION,createMap, cookie);//提交回答问题页面后返回的响应页面
        logger.info("response after submit question: " + questionResponsePage);
        String extractResult = ParsePageUtil.extractResponseAfterSubmitQuestion(questionResponsePage);
        return extractResult;
	}


	/**
	 * 组装提交回答问题时的表单参数
	 * @param createMap
	 */
	private void buildSubmitQuestionParameter(Map<String, String> createMap) {
		createMap.put("kbaList[0].derivativecode", inputNameValue.get("kbaList[0].derivativecode"));
		createMap.put("kbaList[1].derivativecode", inputNameValue.get("kbaList[1].derivativecode"));
		createMap.put("kbaList[2].derivativecode", inputNameValue.get("kbaList[2].derivativecode"));
		createMap.put("kbaList[3].derivativecode", inputNameValue.get("kbaList[3].derivativecode"));
		createMap.put("kbaList[4].derivativecode", inputNameValue.get("kbaList[4].derivativecode"));
		createMap.put("kbaList[0].businesstype", inputNameValue.get("kbaList[0].businesstypee"));
		createMap.put("kbaList[1].businesstype", inputNameValue.get("kbaList[1].businesstypee"));
		createMap.put("kbaList[2].businesstype", inputNameValue.get("kbaList[2].businesstypee"));
		createMap.put("kbaList[3].businesstype", inputNameValue.get("kbaList[3].businesstypee"));
		createMap.put("kbaList[4].businesstype", inputNameValue.get("kbaList[4].businesstypee"));
		createMap.put("kbaList[0].questionno", inputNameValue.get("kbaList[0].questionno"));
		createMap.put("kbaList[1].questionno", inputNameValue.get("kbaList[1].questionno"));
		createMap.put("kbaList[2].questionno", inputNameValue.get("kbaList[2].questionno"));
		createMap.put("kbaList[3].questionno", inputNameValue.get("kbaList[3].questionno"));
		createMap.put("kbaList[4].questionno", inputNameValue.get("kbaList[4].questionno"));
		createMap.put("kbaList[0].kbanum", inputNameValue.get("kbaList[0].kbanum"));
		createMap.put("kbaList[1].kbanum", inputNameValue.get("kbaList[1].kbanum"));
		createMap.put("kbaList[2].kbanum", inputNameValue.get("kbaList[2].kbanum"));
		createMap.put("kbaList[3].kbanum", inputNameValue.get("kbaList[3].kbanum"));
		createMap.put("kbaList[4].kbanum", inputNameValue.get("kbaList[4].kbanum"));
		createMap.put("kbaList[0].question", inputNameValue.get("kbaList[0].question"));
		createMap.put("kbaList[1].question", inputNameValue.get("kbaList[1].question"));
		createMap.put("kbaList[2].question", inputNameValue.get("kbaList[2].question"));
		createMap.put("kbaList[3].question", inputNameValue.get("kbaList[3].question"));
		createMap.put("kbaList[4].question", inputNameValue.get("kbaList[4].question"));
		createMap.put("kbaList[0].options1", inputNameValue.get("kbaList[0].options1"));
		createMap.put("kbaList[1].options1", inputNameValue.get("kbaList[1].options1"));
		createMap.put("kbaList[2].options1", inputNameValue.get("kbaList[2].options1"));
		createMap.put("kbaList[3].options1", inputNameValue.get("kbaList[3].options1"));
		createMap.put("kbaList[4].options1", inputNameValue.get("kbaList[4].options1"));
		createMap.put("kbaList[0].options2", inputNameValue.get("kbaList[0].options2"));
		createMap.put("kbaList[1].options2", inputNameValue.get("kbaList[1].options2"));
		createMap.put("kbaList[2].options2", inputNameValue.get("kbaList[2].options2"));
		createMap.put("kbaList[3].options2", inputNameValue.get("kbaList[3].options2"));
		createMap.put("kbaList[4].options2", inputNameValue.get("kbaList[4].options2"));
		createMap.put("kbaList[0].options3", inputNameValue.get("kbaList[0].options3"));
		createMap.put("kbaList[1].options3", inputNameValue.get("kbaList[1].options3"));
		createMap.put("kbaList[2].options3", inputNameValue.get("kbaList[2].options3"));
		createMap.put("kbaList[3].options3", inputNameValue.get("kbaList[3].options3"));
		createMap.put("kbaList[4].options3", inputNameValue.get("kbaList[4].options3"));
		createMap.put("kbaList[0].options4", inputNameValue.get("kbaList[0].options4"));
		createMap.put("kbaList[1].options4", inputNameValue.get("kbaList[1].options4"));
		createMap.put("kbaList[2].options4", inputNameValue.get("kbaList[2].options4"));
		createMap.put("kbaList[3].options4", inputNameValue.get("kbaList[3].options4"));
		createMap.put("kbaList[4].options4", inputNameValue.get("kbaList[4].options4"));
		createMap.put("kbaList[0].options5", inputNameValue.get("kbaList[0].options5"));
		createMap.put("kbaList[1].options5", inputNameValue.get("kbaList[1].options5"));
		createMap.put("kbaList[2].options5", inputNameValue.get("kbaList[2].options5"));
		createMap.put("kbaList[3].options5", inputNameValue.get("kbaList[3].options5"));
		createMap.put("kbaList[4].options5", inputNameValue.get("kbaList[4].options5"));
	}
	
}
