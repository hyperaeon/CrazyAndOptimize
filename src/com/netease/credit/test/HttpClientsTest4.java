package com.netease.credit.test;

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

import com.netease.util.ConstantUtil;
import com.netease.util.HttpClientUtil;
import com.netease.util.ParsePageUtil;

public class HttpClientsTest4 {

	private String charset = "utf-8";

	private String loginUrl = "https://ipcrs.pbccrc.org.cn/page/login/loginreg.jsp"; //get请求
	
	private String regUrl = "https://ipcrs.pbccrc.org.cn/userReg.do";//post请求
	
	private String exectLoginUrl = "https://ipcrs.pbccrc.org.cn/login.do";//post请求
	
	private String queryReportUrl = "https://ipcrs.pbccrc.org.cn/reportAction.do?method=queryReport"; //get请求
    
	private String imageUrl = "https://ipcrs.pbccrc.org.cn/imgrc.do?a=" + new Date().getTime();//post
	
	private String getSimpleReportUrl = "https://ipcrs.pbccrc.org.cn/simpleReport.do";//post
	
	private String newerUrl = "https://ipcrs.pbccrc.org.cn/setSafetyLevel.do?method=index&isnew=true";//get
	private String newerUrl_1 = "https://ipcrs.pbccrc.org.cn/setSafetyLevel.do";//post
	private String newerUrl_2 = "https://ipcrs.pbccrc.org.cn/setSafetyLevel.do";//post  
	private String newerUrl_3 = "https://ipcrs.pbccrc.org.cn/setSafetyLevel.do?method=saveKbaApply";//post
	private String newerUrl_4 = "https://ipcrs.pbccrc.org.cn/setSafetyLevel.do?method=applySuccess";//post
	
	private String questionBeforeGetReport = "https://ipcrs.pbccrc.org.cn/reportAction.do?method=checkishasreport";//获取报告之前需要回答的问题

	private String applyReportUrl = "https://ipcrs.pbccrc.org.cn/reportAction.do?method=applicationReport";//点击“申请信用信息”对应的URL
	
	private static Header[] headers = null;

	private static List<String> cookieList = new ArrayList<String>();
	
	private static String cookie = "";
	
	private static Map<String, String> inputNameValue = new HashMap<String, String>();//存放inpu中的name和value
	
	/**
	 * 获取验证码
	 * @throws Exception
	 */
	public void test() throws Exception {
		HttpClientUtil3 httpClientUtil = new HttpClientUtil3();
        Map<String,String> createMap = new HashMap<String,String>();
        createMap.put("org.apache.struts.taglib.html.TOKEN","26cc5591147b2d14ae3320bce2e0b283");
        String httpOrgCreateTestRtn = httpClientUtil.downloadImage(imageUrl,createMap, cookie);  
        System.out.println("result:"+httpOrgCreateTestRtn); 
	}
	
	
	public void test_1() throws Exception {
		HttpClientUtil3 httpClientUtil = new HttpClientUtil3();
        Map<String,String> createMap = new HashMap<String,String>();
//		createMap.put("loginname","jonney_zh8");
//		createMap.put("password","ml520zl");
//		createMap.put("loginname","superDCH");
//		createMap.put("password","liuliming321");
//		createMap.put("loginname","adminadmin4");
//		createMap.put("password","123456789liyong");
//		createMap.put("loginname","jonney_zh11");
//		createMap.put("password","ml520zl");
		createMap.put("loginname","geyuhao123456");
		createMap.put("password","090514zhengxin");
		createMap.put("method","login");
		createMap.put("date","1463573916280");
		createMap.put("_@IMGRC@_","8hk6qk");
        createMap.put("org.apache.struts.taglib.html.TOKEN","26cc5591147b2d34ae3320bce2e0b383");
        String httpOrgCreateTestRtn = httpClientUtil.doPost_1(exectLoginUrl,createMap, cookie);  
        System.out.println("result:"+httpOrgCreateTestRtn); 
	}
	
	//获取报告
	public void test_4() throws Exception {
		HttpClientUtil3 httpClientUtil = new HttpClientUtil3();
        Map<String,String> createMap = new HashMap<String,String>();
        String httpOrgCreateTestRtn = httpClientUtil.doGet(queryReportUrl, cookie);  
		System.out.println("result :"+httpOrgCreateTestRtn);
	}
	
	/**
	 * 获取首页的header信息，保存到headers中
	 * @throws Exception
	 */
	public void test2() throws Exception {
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
		System.out.println(result);
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

	//征信报告获取最后一步
	public void test_5() throws Exception {
		HttpClientUtil3 httpClientUtil = new HttpClientUtil3();
        Map<String,String> createMap = new HashMap<String,String>();

		createMap.put("method","viewReport");
		createMap.put("reportformat","21");
		createMap.put("tradeCode","r47rht");
        String httpOrgCreateTestRtn = httpClientUtil.doPost_1(getSimpleReportUrl,createMap, cookie);  
        System.out.println("result:"+httpOrgCreateTestRtn); 
	}
	
	

	/*
	 * 新用户刚登陆需要确实安全升级下一步
	 */
	public void test_6() throws Exception {
		SSLClient httpClient = new SSLClient();
		HttpGet get = new HttpGet(newerUrl);
		HttpResponse response = httpClient.execute(get);
		String result = null;
		if(response != null){
            HttpEntity resEntity = response.getEntity();  
            if(resEntity != null){  
                result = EntityUtils.toString(resEntity,charset); 
            }
        }
		System.out.println("新用户刚登陆需要确实安全升级下一步："+result);
	}
	
	//新注册登录的用户就会显示弹出确定按钮
		public void test_66() throws Exception {
			HttpClientUtil3 httpClientUtil = new HttpClientUtil3();
	        Map<String,String> createMap = new HashMap<String,String>();
	        String httpOrgCreateTestRtn = httpClientUtil.doGet(newerUrl, cookie);  
			System.out.println("新用户刚登陆需要确实安全升级下一步 :"+httpOrgCreateTestRtn);
		}
	
	//需要第2次确定一下
	public void test_7() throws Exception {
		HttpClientUtil3 httpClientUtil = new HttpClientUtil3();
        Map<String,String> createMap = new HashMap<String,String>();

		createMap.put("method","setSafetyLevelStep2");
        String httpOrgCreateTestRtn = httpClientUtil.doPost_1(newerUrl_1,createMap, cookie);
        inputNameValue = ParsePageUtil.parseInput(httpOrgCreateTestRtn);
        System.out.println("result:"+httpOrgCreateTestRtn); 
	}
	
	//需要第3次确定一下
		public String test_8() throws Exception {
			HttpClientUtil3 httpClientUtil = new HttpClientUtil3();
	        Map<String,String> createMap = new HashMap<String,String>();
			createMap.put("method","chooseCertify");
	        createMap.put("authtype","2");
	        createMap.put("org.apache.struts.taglib.html.TOKEN",inputNameValue.get(ConstantUtil.TOKEN_NAME));
	        String httpOrgCreateTestRtn = httpClientUtil.doPost_2(newerUrl_2,createMap, cookie);  
	        System.out.println("the answer is :"+httpOrgCreateTestRtn); 
	        return httpOrgCreateTestRtn;
		}
		
		/**
		 * 点击【申请信用信息】所发的请求
		 * @return
		 * @throws Exception
		 */
		public String test_9() throws Exception {
			HttpClientUtil3 httpClientUtil = new HttpClientUtil3();
	        Map<String,String> createMap = new HashMap<String,String>();
			createMap.put("method","applicationReport");
	        String httpOrgCreateTestRtn = httpClientUtil.doPost_5(applyReportUrl,createMap, cookie);  
	        inputNameValue = ParsePageUtil.parseInput(httpOrgCreateTestRtn);
	        System.out.println("applying info:"+httpOrgCreateTestRtn); 
	        return httpOrgCreateTestRtn;
		}

		/**
		 * 获取报告的回答问题页面
		 * @return
		 * @throws Exception
		 */
		public String test_10() throws Exception {
			HttpClientUtil3 httpClientUtil = new HttpClientUtil3();
	        Map<String,String> createMap = new HashMap<String,String>();
			createMap.put("method","checkishasreport");
			createMap.put(ConstantUtil.TOKEN_NAME, inputNameValue.get(ConstantUtil.TOKEN_NAME));
			createMap.put(ConstantUtil.AUTHTYPE,"2");
			createMap.put(ConstantUtil.APPLICATION_OPTION,"21");
	        String httpOrgCreateTestRtn = httpClientUtil.doPost_3(questionBeforeGetReport,createMap, cookie);  
	        inputNameValue = ParsePageUtil.parseInput(httpOrgCreateTestRtn);
	        System.out.println("question page:"+httpOrgCreateTestRtn);
	        return httpOrgCreateTestRtn;
		}
		
		/**
		 * 提交获取报告的回答问题页面
		 * @return
		 * @throws Exception
		 */
		public String test_11() throws Exception {
			HttpClientUtil3 httpClientUtil = new HttpClientUtil3();
	        Map<String,String> createMap = new HashMap<String,String>();
			createMap.put("method","");
			createMap.put(ConstantUtil.TOKEN_NAME, inputNameValue.get(ConstantUtil.TOKEN_NAME));
			createMap.put(ConstantUtil.AUTHTYPE,"2");
			createMap.put(ConstantUtil.APPLICATION_OPTION,"21");
			createMap.put("kbaList[0].answerresult", "1");
			createMap.put("kbaList[0].options", "1");
			createMap.put("kbaList[1].answerresult", "1");
			createMap.put("kbaList[1].options", "1");
			createMap.put("kbaList[2].answerresult", "1");
			createMap.put("kbaList[2].options", "1");
			createMap.put("kbaList[3].answerresult", "1");
			createMap.put("kbaList[3].options", "1");
			createMap.put("kbaList[4].answerresult", "1");
			createMap.put("kbaList[4].options", "1");
	        String httpOrgCreateTestRtn = httpClientUtil.doPost_4(
	        		ConstantUtil.SUBMIT_REPORT_QUESTION,createMap, cookie);  
	        System.out.println("response after submit question:"+httpOrgCreateTestRtn);
	        return httpOrgCreateTestRtn;
		}
		
		//第四步，回答问题，通过安全校验，目前客户回答的问题暂时都先写死 默认都是1
		public String SecurityFourthStep(Map<String,String> createMap) throws Exception {
			HttpClientUtil httpClientUtil = new HttpClientUtil();
		    Map<String,String> createMap1 = createMap;
		    createMap1.remove("method");
		//    createMap1.remove("_@IMGRC@_");
		    createMap1.remove("");
		    createMap1.put("kbaList[0].answerresult", "1");
		    createMap1.put("kbaList[0].options", "1");
		    createMap1.put("kbaList[1].answerresult", "1");
		    createMap1.put("kbaList[1].options", "1");
		    createMap1.put("kbaList[2].answerresult", "1");
		    createMap1.put("kbaList[2].options", "1");
		    createMap1.put("kbaList[3].answerresult", "1");
		    createMap1.put("kbaList[3].options", "1");
		    createMap1.put("kbaList[4].answerresult", "1");
		    createMap1.put("kbaList[4].options", "1");
		    
		    String result = httpClientUtil.doPost_2(newerUrl_3,createMap1, cookie);  
		    //logger.debug("新用户刚登陆需要确实安全升级第四步 :{} ",result);
		    System.out.println("result:"+result); 
		    return result;
		}
		
		
		//最后一步
		public String lastStep() throws Exception {
			HttpClientUtil3 httpClientUtil = new HttpClientUtil3();
	        Map<String,String> createMap = new HashMap<String,String>();
			createMap.put("org.apache.struts.taglib.html.TOKEN","e13b6728aeae36acc3b29fbfadff36b3");
	        createMap.put("counttime","");
	        createMap.put("authtype","2");
	        createMap.put("ApplicationOption","21");
	        String httpOrgCreateTestRtn = httpClientUtil.doPost_2(newerUrl_4,createMap, cookie);  
	        System.out.println("the last answer is :"+httpOrgCreateTestRtn); 
	        return httpOrgCreateTestRtn;
		}
		
	public static void main(String[] args) throws Exception {
		HttpClientsTest4 test = new HttpClientsTest4();
		test.test2();//初始化
		test.test();//获取验证码
		test.test_1();//登陆
//		test.test_4();//征信报告验证码
//		test.test_5();//征信报告最后一步
//		test.test_66();//首次登录征信系统弹出的页面
//		test.test_7();//新手导航里的下一步

//		String content=test.test_8();//获取问题内容
		
//		Map<String,String> map=ParsePageUtil.parseInput(content);
//		test.SecurityFourthStep(map);
//		test.lastStep();
//		test.test_9();
		String content = test.test_10();
		Map<String, List<String>> map = ParsePageUtil.extractQuestion(content);
		System.out.println(map.size());
		test.test_11();
	}
}
