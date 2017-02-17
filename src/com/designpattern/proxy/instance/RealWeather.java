package com.designpattern.proxy.instance;

import org.apache.commons.lang.StringUtils;

public class RealWeather implements Weather {

	protected String url = "http://www.weather.com";
	
	protected String weatherXml = "";
	
	public RealWeather() {
		
	}
	
	@Override
	public void request(String city) {
		weatherXml = getContents(city);
	}

	private String getContents(String city) {
		return url + city;
	}

	@Override
	public String display(String city) {
		if (StringUtils.isBlank(weatherXml)) {
			request(city);
		}
		weatherXml = simpleXmlLoad(weatherXml);
		return weatherXml;
	}

	private String simpleXmlLoad(String weatherXml2) {
		return weatherXml2;
	}

	@Override
	public boolean isValidCity(String city) {
		// TODO Auto-generated method stub
		return false;
	}

}
