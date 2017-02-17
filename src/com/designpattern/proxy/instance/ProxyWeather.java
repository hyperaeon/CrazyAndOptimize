package com.designpattern.proxy.instance;

public class ProxyWeather implements Weather {

	private Weather client;
	
	
	private Weather client() {
		if (!(client instanceof RealWeather)) {
			client = new RealWeather();
		}
		return client;
	}
	
	@Override
	public void request(String city) {
		client().request(city);

	}

	@Override
	public String display(String city) {
		return client().display(city);
	}

	@Override
	public boolean isValidCity(String city) {
		return client().isValidCity(city);
	}

}
