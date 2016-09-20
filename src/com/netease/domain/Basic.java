package com.netease.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity(name="Basic")
public class Basic {
	
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
	private Integer id;
	
	@Column(name="report_number", nullable = false, length = 22)
	private String reportNumber;
	
//	@Column(name="name", length = 255)
//	private String name;
	 
	@Column(name="query_time")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime query_time;
	
	@Column(name="report_time")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime reportTime;
	
	@Column(name="user_id")
	private Integer userId;
	
//	@Column(name="credential_type")
//	private Integer credential_type;
//	
//	@Column(name="credential_number", length = 18)
//	private String credential_number;
//	
//	@Column(name="is_married")
//	private boolean is_married;
	
	@CreatedDate
	@Column(name="create_time")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime create_time;
	
	@LastModifiedDate
	@Column(name="update_time")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime update_time;

	//该报告是否已经被逻辑删除
	@Column(name="is_delete")
	private Integer isDelete;
	
	
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getReportNumber() {
		return reportNumber;
	}
	public void setReportNumber(String reportNumber) {
		this.reportNumber = reportNumber;
	}
	//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
	public DateTime getQuery_time() {
		return query_time;
	}
	public void setQuery_time(DateTime query_time) {
		this.query_time = query_time;
	}
	
	public DateTime getReportTime() {
		return reportTime;
	}
	public void setReportTime(DateTime reportTime) {
		this.reportTime = reportTime;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	//	public Integer getCredential_type() {
//		return credential_type;
//	}
//	public void setCredential_type(Integer credential_type) {
//		this.credential_type = credential_type;
//	}
//	public String getCredential_number() {
//		return credential_number;
//	}
//	public void setCredential_number(String credential_number) {
//		this.credential_number = credential_number;
//	}
//	public boolean getIs_married() {
//		return is_married;
//	}
//	public void setIs_married(boolean is_married) {
//		this.is_married = is_married;
//	}
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
	@Override
	public String toString() {
		return "Basic [id=" + id + ", report_number=" + reportNumber + ", query_time=" + query_time + ", reportTime="
				+ reportTime + ", userId=" + userId + ", create_time=" + create_time + ", update_time=" + update_time
				+ ", isDelete=" + isDelete + "]";
	}
	
	
	
}
