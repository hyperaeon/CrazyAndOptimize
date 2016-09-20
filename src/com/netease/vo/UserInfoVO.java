package com.netease.vo;

public class UserInfoVO {

	private String name;//姓名
	
	private String certType = "0";//证件类型，征信平台默认为身份证（对应0）
	
	private String certNo;//证件号码
	
	private String checkCode;//验证码
	
	private String checkAgreement = "on";//勾选协议，默认为勾选上
	
	private String loginName;//登录名
	
	private String password;//密码
	
	private String confirmPassword;//确认密码
	
	private String email;//电子邮箱
	
	private String mobileTel;//手机号码
	
	private String tcId;//隐藏域中的与动态码一起校验的字段
	
	private String counttime;//前端计数，值不能低于2
	
	private String verifyCode;//注册时需要的动态码

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCertType() {
		return certType;
	}

	public void setCertType(String certType) {
		this.certType = certType;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public String getCheckAgreement() {
		return checkAgreement;
	}

	public void setCheckAgreement(String checkAgreement) {
		this.checkAgreement = checkAgreement;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileTel() {
		return mobileTel;
	}

	public void setMobileTel(String mobileTel) {
		this.mobileTel = mobileTel;
	}

	public String getTcId() {
		return tcId;
	}

	public void setTcId(String tcId) {
		this.tcId = tcId;
	}

	public String getCounttime() {
		return counttime;
	}

	public void setCounttime(String counttime) {
		this.counttime = counttime;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	
}
