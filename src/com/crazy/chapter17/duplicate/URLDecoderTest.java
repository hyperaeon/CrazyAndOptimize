package com.crazy.chapter17.duplicate;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDecoderTest {

	public static void main(String[] args) throws Exception {
		System.out.println(URLDecoder.decode("%B7%E8%BF%F1java", "GBK"));
		System.out.println(URLEncoder.encode("疯狂java讲义", "GBK"));
	}
}
