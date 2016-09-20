package com.netease.util;

/**
 * 封装常量
 * @author hzliyong
 *
 */
public class ConstantUtil
 {

	/**
	 * 请求用到的静态URL
	 */
	public static final String HOST = "ipcrs.pbccrc.org.cn";//host
	
	public static final String ORIGIN = "https://ipcrs.pbccrc.org.cn";//中国人民银行征信中心主页
	
	public static final String LOGIN_URL = "https://ipcrs.pbccrc.org.cn/page/login/loginreg.jsp";//登录页面url
	
	public static final String REGURL = "https://ipcrs.pbccrc.org.cn/userReg.do";//注册页面url

	public static final String APPLY_REPORTURL = "https://ipcrs.pbccrc.org.cn/reportAction.do?method=applicationReport";//点击“申请信用信息”对应的URL

	public static final String QUESTION_BEFORE_GETREPORT = "https://ipcrs.pbccrc.org.cn/reportAction.do?method=checkishasreport";//获取报告之前需要回答的问题
	
	public static final String SUBMIT_REPORT_QUESTION = "https://ipcrs.pbccrc.org.cn/reportAction.do?method=submitKBA";//获取报告时回答问题后的提交URL
	
	public static final String APPLY_REPORT_REFERER = "https://ipcrs.pbccrc.org.cn/menu.do";//点击【申请信用信息】时的refer
	
	public static final String REFETCH_QUESTION_URL = "https://ipcrs.pbccrc.org.cn/reportAction.do";//重新获取问题时的url
	
	public static final String SMS_URL = "http://106.ihuyi.com/webservice/sms.php?method=Submit";//发送短信用的服务器地址
	
	public static final String CHARSET = "GBK";

	public static final String TOKEN_NAME = "org.apache.struts.taglib.html.TOKEN";
	
	public static final String METHOD = "method";
	
	public static final String COLON = "：";
	
	public static final String SLASH = "-";
	
	public static final String MOBILE = "mobileTel";
	
	public static final String TWENTY_FOUR = "24小时";
	
	/**
	 * 请求的方法
	 */
	public static final String INIT_REG = "initReg";//注册流程初始化方法
	
	public static final String GET_ACTIVITAVE_CODE = "getAcvitaveCode";//注册流程中点击获取动态码时触发的ajax请求方法
	
	public static final String CHECK_REG_LOGINNAME_HASUSED = "checkRegLoginnameHasUsed";
	
	public static final String AUTHTYPE = "authtype";
	
	public static final String APPLICATION_OPTION = "ApplicationOption";
	
	public static final String APPLICATION_REPORT = "applicationReport";
	
	public static final String CHECK_ISHAS_REPORT = "checkishasreport";
	
	public static final String VERIFY = "verify";
	
	/**
	 * 前端相关常量
	 */
	public static final String ERROR_FILED = "_error_field_";
	
	public static final String LOGIN_ERROR_MSG_ID = "_@MSG@_";
	
	/**
	 * 解析报告时需要分隔的符号
	 */
	public static final String LOAN_DETAIL_PREFIX = "<span class=\"h1\"><strong>";
	
	public static final String END_DETAIL_SUFIX = "</strong> </span>";
	
	/**
	 * html页面中的class
	 */
	public static final String CLASS = "class";
	
	public static final String CLASS_OL = "p olstyle";
	
	public static final String CLASS_H1 = "h1";
	
	public static final String CLASS_SPANEM = "spanem";
	
	public static final String REDIO_TYPE = "radio_type";
	
	public static final String VALUE = "value";
	
	public static final String TABLE_MID_BK = "table_mid_bk";
	
	public static final String NOTICE_DIV1 = "notice_div1";
	
	public static final String CLASS_ERRO_DIV1 = "erro_div1";
	
	public static final String CLASS_REPORT_STATUS_FONT = "span-red span-12";
	
	/**
	 * 表单用到的常量
	 */
	public static final String USER_NAME = "userInfoVO.name";
	
	public static final String USER_CERT_TYPE = "userInfoVO.certType";
	
	public static final String USER_CERTNO = "userInfoVO.certNo";
	
	public static final String IDENTIFYING_CODE = "_@IMGRC@_";
	
	public static final String PROTOCOL = "1";
	
	public static final String USER_LOGIN_NAME = "userInfoVO.loginName";
	
	public static final String USER_LOGIN_PASSWORD = "userInfoVO.password";
	
	public static final String USER_LOGIN_COMFIRM_PASSWORD = "userInfoVO.confirmpassword";
	
	public static final String USER_EMAIL = "userInfoVO.email";
	
	public static final String USER_MOBILE = "userInfoVO.mobileTel";
	
	public static final String USER_VERIFY_CODE = "userInfoVO.verifyCode";
	
	public static final String TCID = "tcId";
	
	public static final String COUNTTIME = "counttime";
	
	/**
	 * 请求头用到的常量
	 */
	public static final String REFERER = "Referer";
	
	/**
	 * 信息提示
	 */
	public static final String NON_MESSAGE = "暂无信息";
	
	public static final String EXIST = "已存在";
	
	public static final String RELOGIN = "重新登录";
	
	public static final String REDIO_VALUE = "252421";
	
	/**
	 * 信用报告中用到的常量
	 */
	public static final String ORANIZATION_CHECK = "机构查询记录明细";
	
	public static final String PERSONAL_CHECK = "个人查询记录明细";
	
	/**
	 * 点击信息服务 > 申请信用信息后最下方“个人信用报告”后面的信息
	 */
	public static final String BLANK_MESSAGE = "";//空白，状态为“未获取报告”
	
	public static final String VERIFY_UNPASS = "验证未通过";//状态为“未获取报告”
	
	public static final String HANDLERING = "处理中";//状态为“报告申请中”
	
	public static final String GENERATED = "已生成";//状态为“报告已生成”
	
	
	/**
	 * 返回的http错误代码
	 */
	public static final String TEMPORARILY_MOVED_CODE = "302";
	
	/**
	 * 返回的本系统的错误代码
	 */
	public static final String TRY_TO_GET_REPORT_ERROR = "zx001";//获取报告时失败，包括：1、本系统不存在该登录名对应的用户；2、解析验证码错误；3、登录征信系统失败
	
	/**
	 * 标记
	 */
	public static final String TRUE = "true";
	
	public static final String FALSE = "false";
	
	public static final String FLAG = "flag";
	
}
