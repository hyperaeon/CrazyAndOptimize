package com.netease.domain;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity(name="User")
public class User {

	@Id@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
	private Integer id;
	
	//@Column name指的是数据库中字段的名字
	@Column(name="name", length = 255)
	private String name;
	
	@Column(name="credential_type")
	private Integer credential_type;
	
	@Column(name="credential_number", length = 30)
	private String credential_number;
	
	@Column(name="login_name", length = 16,nullable = false)
	private String loginName;
	
	@Column(name="password", length = 20,nullable = false)
	private String password;
	
	@Column(name="passwordsha", length = 256,nullable = false)
	private String passwordsha;
	
	@Column(name="salt", length = 128,nullable = false)
	private String salt;
	
	@Column(name="email", length = 255)
	private String email;
	
	@Column(name="roles", length = 255)
	@Type(type="text")
	private String roles;

	@Column(name="mobile_number")
	private BigInteger mobileNumber;
	
	@Column(name="security_level")
	private Integer security_level;
	
	@Column(name="is_quick_query")
	private Integer is_quick_query;
	
	@CreatedDate
	@Column(name="create_time")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime create_time;
	
	@LastModifiedDate
	@Column(name="update_time")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime update_time;
	
	@Column(name="create_user", length = 16)
	private String createUser;
	
	@Column(name="report_status")
	private Integer report_status;
	
	@Column(name="user_count")
	private Integer user_count;

	@Column(name="is_married")
	private Integer is_married;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
	public BigInteger getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(BigInteger mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCredential_type() {
		return credential_type;
	}

	public void setCredential_type(Integer credential_type) {
		this.credential_type = credential_type;
	}

	public String getCredential_number() {
		return credential_number;
	}

	public void setCredential_number(String credential_number) {
		this.credential_number = credential_number;
	}

	

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Integer getReport_status() {
		return report_status;
	}

	public void setReport_status(Integer report_status) {
		this.report_status = report_status;
	}

	public Integer getUser_count() {
		return user_count;
	}

	public void setUser_count(Integer user_count) {
		this.user_count = user_count;
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	
	public Integer getSecurity_level() {
		return security_level;
	}

	public void setSecurity_level(Integer security_level) {
		this.security_level = security_level;
	}

	public Integer getIs_quick_query() {
		return is_quick_query;
	}

	public void setIs_quick_query(Integer is_quick_query) {
		this.is_quick_query = is_quick_query;
	}

	public DateTime getCreate_time() {
		return create_time;
	}

	public void setCreate_time(DateTime create_time) {
		this.create_time = create_time;
	}

	public DateTime getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(DateTime update_time) {
		this.update_time = update_time;
	}



	public String getPasswordsha() {
		return passwordsha;
	}

	public void setPasswordsha(String passwordsha) {
		this.passwordsha = passwordsha;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public Integer getIs_married() {
		return is_married;
	}

	public void setIs_married(Integer is_married) {
		this.is_married = is_married;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", credential_type="
				+ credential_type + ", credential_number=" + credential_number
				+ ", loginName=" + loginName + ", password=" + password
				+ ", passwordsha=" + passwordsha + ", salt=" + salt
				+ ", email=" + email + ", roles=" + roles + ", mobile_number="
				+ mobileNumber + ", security_level=" + security_level
				+ ", is_quick_query=" + is_quick_query + ", create_time="
				+ create_time + ", update_time=" + update_time
				+ ", createUser=" + createUser + ", report_status="
				+ report_status + ", user_count=" + user_count
				+ ", is_married=" + is_married + "]";
	}

}
