package com.test.vo;

public class MobileHeader {

	// os ， android
	private String platform;
	//操作系统版本号
	private String osVersion;
	//机型
	private String deviceModel;
	//设备号
	private String deviceId;
	//联网方式
	private String network;
	//渠道
	private String channel;
	//客户端版本
	private String appVersion;
	//地区code
	private String areaCode;
	//协议版本号
	private String protocolVersion;
	
	private String ip;
	
	private String os;
	
	private String resolution;

	private String referer;

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getProtocolVersion() {
		return protocolVersion;
	}

	public void setProtocolVersion(String protocolVersion) {
		this.protocolVersion = protocolVersion;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getReferer() {
		return referer;
	}

	public void setReferer(String referer) {
		this.referer = referer;
	}

	@Override
	public String toString() {
		return "MobileHeader [platform=" + platform + ", osVersion="
				+ osVersion + ", deviceModel=" + deviceModel + ", deviceId="
				+ deviceId + ", network=" + network + ", channel=" + channel
				+ ", appVersion=" + appVersion + ", areaCode=" + areaCode
				+ ", protocolVersion=" + protocolVersion + ", ip=" + ip
				+ ", os=" + os + ", resolution=" + resolution + ", referer="
				+ referer + "]";
	}
	
	
}
