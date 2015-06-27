package com.interview.chapter9;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class TestUrl {

	private static final String[] URLNAMES = { "http://www.sina.com.cn",
			"http://www.nwu.edu.cn", "http://javapuzzlers.com",
			"http://www.google.com", "http://Javapuzzlers.com",
			"http://apache2-snort.skeybar.dreamhost.com", };

	public static void main(String[] args) throws MalformedURLException {
		Set<URL> favorites = new HashSet<>();
		for (String urlName : URLNAMES) {
			favorites.add(new URL(urlName));
		}
		System.out.println(favorites.size());
	}
}
