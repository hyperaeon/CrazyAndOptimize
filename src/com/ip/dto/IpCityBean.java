package com.ip.dto;

import java.io.Serializable;

/**
 * 根据ip返回对应的城市信息、大区、省份、城市、国家
 * @author hzliyong
 *
 */
public class IpCityBean implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2805027393801401926L;

	private long ipStartLong;

	private long ipEndLong;

	private String continent;

	private String country;

	private String province;

	private String city;

	private String county;

	private String isp;

	private String admincode;

	private String enCountry;

	private String abbEname;

	private String longitude;

	private String latitude;

	
	public IpCityBean(long ipStartLong, long ipEndLong, String continent, String country, String province, String city,
			String county, String isp, String admincode, String enCountry, String abbEname, String longitude,
			String latitude) {
		super();
		this.ipStartLong = ipStartLong;
		this.ipEndLong = ipEndLong;
		this.continent = continent;
		this.country = country;
		this.province = province;
		this.city = city;
		this.county = county;
		this.isp = isp;
		this.admincode = admincode;
		this.enCountry = enCountry;
		this.abbEname = abbEname;
		this.longitude = longitude;
		this.latitude = latitude;
	}



	public long getIpStartLong() {
		return ipStartLong;
	}



	public void setIpStartLong(long ipStartLong) {
		this.ipStartLong = ipStartLong;
	}



	public long getIpEndLong() {
		return ipEndLong;
	}



	public void setIpEndLong(long ipEndLong) {
		this.ipEndLong = ipEndLong;
	}



	public String getContinent() {
		return continent;
	}



	public void setContinent(String continent) {
		this.continent = continent;
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



	public String getCounty() {
		return county;
	}



	public void setCounty(String county) {
		this.county = county;
	}



	public String getIsp() {
		return isp;
	}



	public void setIsp(String isp) {
		this.isp = isp;
	}



	public String getAdmincode() {
		return admincode;
	}



	public void setAdmincode(String admincode) {
		this.admincode = admincode;
	}



	public String getEnCountry() {
		return enCountry;
	}



	public void setEnCountry(String enCountry) {
		this.enCountry = enCountry;
	}



	public String getAbbEname() {
		return abbEname;
	}



	public void setAbbEname(String abbEname) {
		this.abbEname = abbEname;
	}



	public String getLongitude() {
		return longitude;
	}



	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}



	public String getLatitude() {
		return latitude;
	}



	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}



	@Override
	public String toString() {
		return "IpCityBean [ipStartLong=" + ipStartLong + ", ipEndLong="
				+ ipEndLong + ", continent=" + continent + ", country="
				+ country + ", province=" + province + ", city=" + city
				+ ", county=" + county + ", isp=" + isp + ", admincode="
				+ admincode + ", enCountry=" + enCountry + ", abbEname="
				+ abbEname + ", longitude=" + longitude + ", latitude="
				+ latitude + "]";
	}

}
