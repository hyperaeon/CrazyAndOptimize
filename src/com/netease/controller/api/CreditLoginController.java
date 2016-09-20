package com.netease.controller.api;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.netease.controller.base.BaseController;
import com.netease.domain.Basic;
import com.netease.domain.Check_Record;
import com.netease.domain.Loan_Record_Detail;
import com.netease.domain.New_User;
import com.netease.domain.User;
import com.netease.enums.CredentialType;
import com.netease.enums.ReportStatusType;
import com.netease.service.BasicService;
import com.netease.service.Check_RecordService;
import com.netease.service.Loan_RecordService;
import com.netease.service.Loan_Record_DetailService;
import com.netease.service.NewUserService;
import com.netease.service.RegisterFlowService;
import com.netease.service.ReportService;
import com.netease.service.SmsService;
import com.netease.service.UserService;
import com.netease.util.CommonServiceUtil;
import com.netease.util.Tools;
import com.netease.util.ValidateUtil;
import com.netease.vo.UserInfoVO;

/**
 * 
 * @ClassName: CreditLoginController
 * @Description: 征信登陆模块
 * @author:JonneyZhang
 * @date: 2016年5月23日 下午1:28:22
 */
@Controller
@SessionAttributes({"creditCardApprovalList","personageQueryList","loanAfterManagerList","loanApprovalList"})
public class CreditLoginController extends BaseController {
	final static Logger logger = LoggerFactory.getLogger(CreditLoginController.class);
	
	private static HashMap<String , String > hashMap=new LinkedHashMap<String,String >();

	@Autowired
	private HttpSession session;

	@Autowired
	private UserService userService;

    @Autowired
    RegisterFlowService registerFlowService;
    
    @Autowired
    ReportService reportService;
    
    @Autowired
    Loan_RecordService loan_RecordService;
    
    @Autowired
    Loan_Record_DetailService loan_Record_DetailService;
    
    @Autowired
    Check_RecordService check_RecordService;
    
    @Autowired
    BasicService basicService;
    
    @Autowired
    SmsService smsService;
    
    @Autowired
    NewUserService newUserService;

	@RequestMapping("/Credit/login")
	public String login(HttpServletRequest request,Model model) {
		CommonServiceUtil.getBaseURL(request, model);
		return "neteaseCredit/login";
	}
	
	/**
	 * 注册页面跳转
	 * 
	 * @param m
	 * @return 进入注册页面
	 */

    @RequestMapping(value = "/Credit/register_1", method = {RequestMethod.POST, RequestMethod.GET})
    public String CreditRegister_1(HttpServletRequest request ,Model m) {
		CommonServiceUtil.getBaseURL(request, m);
    	return "neteaseCredit/register_1";
    }
    
    /**
     * 跳转到帮助页面
     * @param request
     * @param m
     * @return
     */
    @RequestMapping(value = "/Credit/help", method = RequestMethod.GET)
    public String creditHelp(HttpServletRequest request, Model m) {
    	CommonServiceUtil.getBaseURL(request, m);
    	return "neteaseCredit/help";
    }
    
    /**
     * 跳转到帮助页面
     * @param request
     * @param m
     * @return
     */
    @RequestMapping(value = "/Credit/creditManager_help", method = RequestMethod.GET)
    public String creditManagerHelp(HttpServletRequest request, Model m) {
    	CommonServiceUtil.getBaseURL(request, m);
    	return "neteaseCredit/creditManager_help";
    }
    
	/**
	 * 注册页面跳转1
	 * 
	 * @param m
	 * @param name
	 *            姓名
	 * @param credential_number
	 *            身份证
	 * @param verification_code
	 *            验证码
	 * @return 注册页面2
	 */
	@RequestMapping(value = "/Credit/register_2", method = RequestMethod.POST)
	public String CreditRegister_2(HttpServletRequest request,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "credential_number") String credential_number,
			@RequestParam(value = "verification_code") String verification_code, Model m) {
		logger.info("CreditRegister_2");
		CommonServiceUtil.getBaseURL(request, m);
		// 输入数据合法性基础校验
		if (Tools.isEmpty(name)) {
			m.addAttribute("credential_number",credential_number);
			m.addAttribute("info", "请输入姓名");
			return CreditRegister_1(request, m);
		}
		if (Tools.isEmpty(credential_number) || !ValidateUtil.validateCredential_number(credential_number)) {
			m.addAttribute("name",name);
			m.addAttribute("credential_number",credential_number);
			m.addAttribute("info", "请输入有效二代身份证号");
			return CreditRegister_1(request, m);
		}
		if (Tools.isEmpty(verification_code)) {
			m.addAttribute("credential_number",credential_number);
			m.addAttribute("name",name);
			m.addAttribute("info", "请输入验证码");
			return CreditRegister_1(request, m);
		}
		UserInfoVO userInfoVo = new UserInfoVO();
		userInfoVo.setName(name);
		userInfoVo.setCertNo(credential_number);
		userInfoVo.setCheckCode(verification_code);
		String result = "";
		try {
			result = registerFlowService.inputBasicInfo(userInfoVo);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}
		if (result.isEmpty() || "".equals(result)) {
			// 创建一个session保存用户名字，身份证
			session.setAttribute("name", name);
			session.setAttribute("credential_number", credential_number);
			return "neteaseCredit/register_2";
		} else {
			logger.info("注册第一步结果信息:" + result);
			m.addAttribute("info", result);
			return CreditRegister_1(request,m);
		}
	}

	/**
	 * 注册页面2，获取手机短信动态码
	 * 
	 * @param m
	 * @param login_name
	 *            登录名
	 * @param password
	 *            密码
	 * @param mobile_numble
	 *            手机号
	 * @return 注册页面2，带回登录名，密码和手机号
	 */
//	@RequestMapping(value = "/Credit/register_2/credential", method = RequestMethod.POST)
//	public String CreditRegister_2_credential(@RequestParam(value = "login_name") String login_name,
//			@RequestParam(value = "password") String password,
//			@RequestParam(value = "mobile_numble") String mobile_numble, Model m) {
//		logger.info("请求CreditRegister_2_credential开始");
//		// 输入数据合法性基础校验
//		if (Tools.isEmpty(login_name) && ValidateUtil.validateLogin_name(login_name)) {
//			m.addAttribute("info", "请输入6-16位的数字、字母、-、_、/");
//			return "neteaseCredit/register_2";
//		}
//		if (Tools.isEmpty(password) && ValidateUtil.validatePassword(password)) {
//			m.addAttribute("info", "请输入6-20位的数字、字母组合");
//			return "neteaseCredit/register_2";
//		}
//		if (Tools.isEmpty(mobile_numble) && ValidateUtil.validateMobile(mobile_numble)) {
//			m.addAttribute("info", "请输入有效手机号");
//			return "neteaseCredit/register_2";
//		}
//		m.addAttribute("login_name", login_name);
//		m.addAttribute("password", password);
//		m.addAttribute("mobile_numble", mobile_numble);
//		String tcId = registerFlowService.getDynamicCode(mobile_numble);
//		m.addAttribute("tcid", tcId);
//		session.setAttribute("tcid", tcId);
//		return "neteaseCredit/credential";
//	}

	/**
	 * 注册页面跳转3
	 * 
	 * @param m
	 * @param login_name
	 *            登录名
	 * @param password
	 *            密码
	 * @param mobile_numble
	 *            手机号
	 * @param verification_code
	 *            手机动态码
	 * @param tcId
	 *            隐藏验证码
	 * @return 注册结果
	 */
	@RequestMapping(value = "/Credit/register_3", method = RequestMethod.POST)
	public String CreditRegister_3(HttpServletRequest request,
			@RequestParam(value = "login_name") String login_name,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "mobile_numble") String mobile_numble,
			@RequestParam(value = "verification_code_mobile") String verification_code_mobile, Model m) {
		logger.info("CreditRegister_3");
		CommonServiceUtil.getBaseURL(request, m);
		// 输入数据合法性基础校验
		if (Tools.isEmpty(verification_code_mobile)) {
			m.addAttribute("login_name", login_name);
			m.addAttribute("password", password);
			m.addAttribute("mobile_numble", mobile_numble);
			m.addAttribute("info", "请输入手机验证码");
			return "neteaseCredit/register_2";
		}
		UserInfoVO userInfoVo = new UserInfoVO();
		userInfoVo.setName((String) session.getAttribute("name"));
		userInfoVo.setCertType(String.valueOf(CredentialType.IDENTIFICATION.getValue()));
		userInfoVo.setCertNo((String) session.getAttribute("credential_number"));
		userInfoVo.setLoginName(login_name);
		userInfoVo.setPassword(password);
		userInfoVo.setConfirmPassword(password);
		userInfoVo.setMobileTel(mobile_numble);
		userInfoVo.setVerifyCode(verification_code_mobile);
		userInfoVo.setTcId((String) session.getAttribute("tcid"));
		int randCount = (int)(48 * Math.random() + 2);//随机生成2到50的数字
		userInfoVo.setCounttime(Integer.toString(randCount));
		userInfoVo.setEmail("");
		String result = "";

		String randomHex = new SecureRandomNumberGenerator().nextBytes().toHex();
		String passwordSha = new Sha256Hash(password, randomHex).toString();
		logger.info("Name: " + userInfoVo.getName());
		try {
			result = registerFlowService.postSecondReg(userInfoVo);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			logger.info("注册第二部步失败", e);
		}
		if (result.isEmpty() || "".equals(result)) {
			// 注册成功，插入数据库
			User user = new User();
			user.setName((String) session.getAttribute("name"));
			user.setCredential_type(1);
			user.setCredential_number((String) session.getAttribute("credential_number"));
			user.setLoginName(login_name);
			user.setPassword(password);
			user.setPasswordsha(passwordSha);
			user.setMobileNumber(BigInteger.valueOf(Long.valueOf(mobile_numble)));
			user.setSecurity_level(0);
			user.setIs_quick_query(0);
			user.setCreate_time(new DateTime());
			user.setUpdate_time(new DateTime());
			user.setEmail("");
			user.setSalt(randomHex);
			user.setReport_status(ReportStatusType.UNAPPLY.getValue());
			//获取当前登录的用户名
			org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
	    	String create_user = (String)subject.getPrincipal();
	    	if (create_user!=null && !"".equals(create_user)) {
	    		user.setCreateUser(create_user);
			}
	    	else
	    	{
	    		user.setCreateUser(login_name);
	    	}
			userService.save(user);
			logger.info("验证码正确");
			return "neteaseCredit/register_3";
		} else {//注册失败
			m.addAttribute("login_name", login_name);
			m.addAttribute("password", password);
			m.addAttribute("mobile_numble", mobile_numble);
			m.addAttribute("mobile_numble", mobile_numble);
			m.addAttribute("verification_code_mobile", verification_code_mobile);
			m.addAttribute("info", result);
			logger.info("提交到注册第三步：" + " 姓名：" + session.getAttribute("name") + " 身份证号"
					+ session.getAttribute("credential_number") + " 登录名" + login_name + " 密码" + password + " 手机号"
					+ mobile_numble + " 动态码" + verification_code_mobile + " 隐藏动态码" + session.getAttribute("tcid"));
			return "neteaseCredit/register_2";
		}
	}

	/**
	 * 征信管理首页(这个接口没在用)
	 * @param login_name 登录名
	 * **/
	@RequestMapping(value = "/Credit/reportmanager", method = RequestMethod.GET)
	public String ReportManager(HttpServletRequest request,Model m) {
		logger.info("ReportManager");
		CommonServiceUtil.getBaseURL(request, m);
		String createUser = (String) SecurityUtils.getSubject().getPrincipal();
		//List<User> users = userService.findByCreateUser(createUser);
		List<User> users =userService.findByCreateUserAndLoginName(createUser, createUser);
		logger.info("共找到" + users.size() + "个用户");
		m.addAttribute("list", users);
		return "neteaseCredit/creditManager_gyl";
	}

	/**
	 * 还未申请征信报告
	 * @param login_name 登录名
	 * **/
	@RequestMapping(value = "/Credit/apply_report", method = RequestMethod.GET)
	public String applyReport(HttpServletRequest request,
			@RequestParam(value = "login_name") String login_name,
			@RequestParam(value = "report_status") String report_status, Model m) {
		logger.info("apply_report");
		CommonServiceUtil.getBaseURL(request, m);
		m.addAttribute("login_name",login_name);
		return "neteaseCredit/apply_report";
	}

	/**
	 * 申请征信报告进行中
	 * @param login_name 登录名
	 * **/
	@RequestMapping(value = "/Credit/process_report", method = RequestMethod.GET)
	public String processReport(HttpServletRequest request,
			@RequestParam(value = "login_name") String login_name,
			@RequestParam(value = "report_status") String report_status, Model m) {
		logger.info("process_report");
		CommonServiceUtil.getBaseURL(request, m);
		m.addAttribute("login_name", login_name);
		return "neteaseCredit/process_report";
	}

	/**
	 * 已经得到征信报告
	 * @param login_name 登录名
	 * **/
	@RequestMapping(value = "/Credit/access_report", method = RequestMethod.GET)
	public String accessReport(HttpServletRequest request,
			@RequestParam(value = "login_name") String login_name,
			@RequestParam(value = "report_status") String report_status, Model m) {
		logger.info("access_report");
		CommonServiceUtil.getBaseURL(request, m);
		m.addAttribute("login_name", login_name);
		return "neteaseCredit/access_report";
	}

	
	/**
	 * 逻辑删除目前最新的个人报告
	 * @param login_name 登录名
	 * **/
	@RequestMapping(value = "/Credit/deletePersonCreditReport", method = RequestMethod.GET)
	public String deletePersonCreditReport(HttpServletRequest request, 
			@RequestParam(value = "login_name") String login_name,
			@RequestParam(value = "reportId") String report_id,Model m) {
		logger.info("deletePersonCreditReport");
		CommonServiceUtil.getBaseURL(request, m);
		//查找该条报告，逻辑删除
		Basic basic=basicService.findByReportId(Integer.valueOf(report_id));
		basic.setIsDelete(1);
		basicService.save(basic);
		//修改这个人的报告状态为未获取
		User user = userService.getByLoginName(login_name);
		user.setReport_status(ReportStatusType.UNAPPLY.getValue());
		userService.save(user);
		//返回个人征信管理页面
		//List<User> users = userService.findByCreateUser(login_name);
		org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
    	String create_user = (String)subject.getPrincipal();
		List<User> users =userService.findByCreateUserAndLoginName(create_user, login_name);
		logger.info("共找到" + users.size() + "个用户");
		m.addAttribute("list", users);
		return "neteaseCredit/creditManager_gyl";
		
	}
	
	/**
	 * 个人信用报告首页
	 * @param login_name 登录名
	 * **/
	@RequestMapping(value = "/Credit/personCreditReport", method = RequestMethod.GET)
	public String personCreditReport(HttpServletRequest request,
			@RequestParam(value = "login_name") String login_name, Model m) {
		logger.info("personCreditReport");
		CommonServiceUtil.getBaseURL(request, m);
		Map<String,Object> map = new HashMap<String,Object>();
		map = reportService.getPersonCreditReport(login_name);
		m.addAllAttributes(map);
		return "neteaseCredit/personalCreditReport_gyl";
	}
	
	/**
	 * 信用卡明细
	 * @param reportId 报告id
	 * **/
	@RequestMapping(value = "/Credit/creditCardDetail", method = RequestMethod.GET)
	public String creditCardDetail(HttpServletRequest request,
			@RequestParam(value = "reportId") String reportId, Model m) {
		logger.info("查询信用卡记录明细,报告ID："+reportId);
		CommonServiceUtil.getBaseURL(request, m);
		//防止查询不到报告时失败
		if (reportId == null || "".equals(reportId)) {
			return "neteaseCredit/creditCardDetail";
		}
		//查询信用卡发生过逾期的贷记卡账户明细
		List<Loan_Record_Detail> overdueList = loan_Record_DetailService.findCreditCardOverdue(Integer.valueOf(reportId));
		m.addAttribute("overdurList",overdueList);
		logger.info("查询信用卡发生过逾期的贷记卡账户明细："+overdueList.size());
		//查询信用卡从未逾期的贷记卡及透支未超过60天的准贷记卡账户明细
		List<Loan_Record_Detail> noOverdueList = loan_Record_DetailService.findCreditCardNoOverdue(Integer.valueOf(reportId));
		m.addAttribute("noOverdurList", noOverdueList);
		logger.info("查询信用卡从未逾期的贷记卡及透支未超过60天的准贷记卡账户明细："+noOverdueList.size());
		//查询信用卡透支超过60天的贷记卡账户明细
		List<Loan_Record_Detail> overdueSixtyList = loan_Record_DetailService.findCreditCardOverdueSixty(Integer.valueOf(reportId));
		m.addAttribute("overdueSixtyList",overdueSixtyList);
		logger.info("查询信用卡透支超过60天的贷记卡账户明细："+overdueSixtyList.size());
		return "neteaseCredit/creditCardDetail";
	}
	/**
	 * 贷款明细
	 * @param reportId 报告id
	 * **/
	@RequestMapping(value = "/Credit/loanRecordDetail", method = RequestMethod.GET)
	public String loanDetail(HttpServletRequest request,
			@RequestParam(value = "reportId") String reportId, Model m) {
		logger.info("查询贷款记录明细,报告ID："+reportId);
		CommonServiceUtil.getBaseURL(request, m);
		// 防止查询不到报告时失败
		if (reportId == null || "".equals(reportId)) {
			return "neteaseCredit/creditCardDetail";
		}
		//查找住房贷款未逾期账户明细
		List<Loan_Record_Detail> houseLoanNoOverdueList=loan_Record_DetailService.findHouserLoadNoOverdue(Integer.valueOf(reportId));
		//查找住房贷款发生过逾期的账户明细
		List<Loan_Record_Detail> houseLoanOverdueList = loan_Record_DetailService.findHouserLoadOverdue(Integer.valueOf(reportId));
		//查找其他贷款未逾期账户明细
		List<Loan_Record_Detail> otherLoanNoOverdueList = loan_Record_DetailService.findOtherLoadNoOverdue(Integer.valueOf(reportId));
		//查找其他贷款发生过逾期的账户明细
		List<Loan_Record_Detail> otherLoanOverdueList =loan_Record_DetailService.findOtherLoadOverdue(Integer.valueOf(reportId));
		m.addAttribute("houseLoanNoOverdueList",houseLoanNoOverdueList);
		m.addAttribute("houseLoanOverdueList",houseLoanOverdueList);
		m.addAttribute("otherLoanNoOverdueList",otherLoanNoOverdueList);
		m.addAttribute("otherLoanOverdueList",otherLoanOverdueList);
		return "neteaseCredit/loanRecordDetail";
	}
	/**
	 * 查询明细
	 * @param reportId 报告id
	 * **/
	@RequestMapping(value = "/Credit/queryRecordDetail", method = RequestMethod.GET)
	public String queryRecordDetail(HttpServletRequest request,
			@RequestParam(value = "reportId") String reportId, Model m) {
		logger.info("查询明细,报告ID："+reportId);
		CommonServiceUtil.getBaseURL(request, m);
		// 防止查询不到报告时失败
		if (reportId == null || "".equals(reportId)) {
			return "neteaseCredit/creditCardDetail";
		}
		// 信用卡审批
		List<Check_Record> creditCardApprovalList = check_RecordService
				.findCreditCardApproval(Integer.valueOf(reportId));
		// 个人查询
		List<Check_Record> personageQueryList = check_RecordService.findPersonageQuery(Integer.valueOf(reportId));
		// 贷后管理
		List<Check_Record> loanAfterManagerList = check_RecordService.findLoanAfterManager(Integer.valueOf(reportId));
		// 贷款审批
		List<Check_Record> loanApprovalList = check_RecordService.findLoanApproval(Integer.valueOf(reportId));
		m.addAttribute("creditCardApprovalList",creditCardApprovalList);
		m.addAttribute("personageQueryList",personageQueryList);
		m.addAttribute("loanAfterManagerList",loanAfterManagerList);
		m.addAttribute("loanApprovalList",loanApprovalList);
		logger.info("一次查询");
		return "neteaseCredit/queryRecordDetail";
	}
	/**
	 * 测试提交问题查询
	 * @param creditLimit 信用卡额度
	 * **/
	@RequestMapping(value = "/Credit/submitApply_report", method = RequestMethod.GET)
	public String submitApply_report( HttpServletRequest request, HttpServletResponse response,Model m) {
		logger.info("回答问题，把答案提交到后台");
		CommonServiceUtil.getBaseURL(request, m);
		Enumeration<String> names=request.getParameterNames();
		 while (names.hasMoreElements()){
			 String key = names.nextElement();
			 logger.info("key:"+key);
			 
			 logger.info("value:"+request.getParameter(key));
		 }
		      
		
		return "neteaseCredit/apply_report";
	}
	
	//短信注册
	@RequestMapping("/Credit/smsRegister")
	public String mobileLogin(HttpServletRequest request,Model model) {
		CommonServiceUtil.getBaseURL(request, model);
		return "neteaseCredit/creditManager-login";
	}
	
	
	//提交验证码和手机号做平台注册功能
	@RequestMapping(value = "/Credit/smsRegister2", method = {RequestMethod.POST, RequestMethod.GET})
	public String SmsRegisterStep2(HttpServletRequest request,
			@RequestParam(value = "phone_number") String phone_number,Model m) {
		logger.info("userLogin begin");
		CommonServiceUtil.getBaseURL(request, m);
		New_User user=newUserService.findUserByMobileNumber(phone_number);
		if(user==null){
			String randomHex = new SecureRandomNumberGenerator().nextBytes().toHex();
			String passwordSha = new Sha256Hash(phone_number, randomHex).toString();
			user=new New_User();
			user.setMobileNumber(phone_number);
			user.setPassword(phone_number);
			user.setSalt(randomHex);
			user.setPasswordsha(passwordSha);
			user.setCreate_time(new DateTime());
			user.setUpdate_time(new DateTime());
			newUserService.save(user);
			logger.info("success to sava user");
		}
		UsernamePasswordToken token = new UsernamePasswordToken(phone_number, phone_number.toCharArray());
		Subject subject = SecurityUtils.getSubject();
	    //用户登陆网易征信系统
	    subject.login(token);
	    String admin_userName = (String) subject.getPrincipal(); 
	    logger.info("登录名："+admin_userName);
	    List<User> users = userService.findByCreateUser(phone_number);   
		logger.info("共找到"+users.size()+"个用户");
		m.addAttribute("list",users);
		return "neteaseCredit/creditManager_gyl";
	}
}
