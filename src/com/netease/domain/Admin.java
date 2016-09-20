package com.netease.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity(name="admin")
public class Admin {
	
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="username", nullable = false, length = 100)
    private String username;

    @Column(name="password", length = 100)
    private String password;

    @Column(name="salt", length = 50)
    private String salt;

    @Column(name="roles")
    @Type(type="text")
    private String roles;

    @Column(name="realname", length = 100)
    private String realname;

    @Column(name="mobile", length = 50)
    private String mobile;
    
    @Column(name="email", length = 50)
    private String email;

 
	@Column(name="memo")
    @Type(type="text")
    private String memo;

    @Column(name="last_login")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime lastLogin;
    
    //此字段是为设置密码过期的字段；
    @Column(name="over_date")
    private Timestamp over_date;

    @CreatedDate
    @Column(name="created_at")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createdAt;

    @LastModifiedDate
    @Column(name="updated_at")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime updatedAt;
    @LastModifiedDate
    @Column(name="deadline")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime deadline;
	public DateTime getDeadline() {
		return deadline;
	}

	public void setDeadline(DateTime deadline) {
		this.deadline = deadline;
	}

	public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {    
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {    
        return password;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    
    public String getSalt() {
        return salt;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
    
    public String getRoles() {
        return roles;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }
    
    public String getRealname() {
        return realname;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    public String getMobile() {
        return mobile;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
    
    public String getMemo() {
        return memo;
    }

    public void setLastLogin(DateTime lastLogin) {
        this.lastLogin = lastLogin;
    }
    
    public DateTime getLastLogin() {
        return lastLogin;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setUpdatedAt(DateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public DateTime getUpdatedAt() {
        return updatedAt;
    }
    
    //java的Timestamp与mysql的datetime一一对应
    public Timestamp getOver_date() {
        return over_date;
    }

    public void setOver_date(Timestamp over_date) {
        this.over_date = over_date;
    }

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

