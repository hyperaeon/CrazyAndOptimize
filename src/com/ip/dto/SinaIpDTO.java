package com.ip.dto;

import java.io.Serializable;

/**
 * 
 * 新浪ip解析
 * http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json&ip=XXX.XXX.XXX.XXX
 * @author hzliyong
 *
 */
public class SinaIpDTO implements Serializable {

	/**
	 * abc
	 */
	private static final long serialVersionUID = 7131944509050820652L;

	private int ret;
	
	private int start;
	
	private int end;
	
	private String country;
	
	private String province;
	
	private String city;
	
	private String district;
	
	private String isp;
	
	private String type;
	
	private String desc;

	public int getRet() {
		return ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getIsp() {
		return isp;
	}

	public void setIsp(String isp) {
		this.isp = isp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "SinaIpDTO [ret=" + ret + ", start=" + start + ", end=" + end
				+ ", country=" + country + ", province=" + province + ", city="
				+ city + ", district=" + district + ", isp=" + isp + ", type="
				+ type + ", desc=" + desc + "]";
	}
	
	
}
