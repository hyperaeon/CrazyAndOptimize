package com.test;

import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;
import org.dbunit.util.Base64;

public class Base64Test {

	private final static Logger LOGGER = Logger.getLogger(Base64Test.class);
	
	public static void decode(String src) throws UnsupportedEncodingException {
		LOGGER.info("decode begin");
		String decodeString = Base64.decodeToString(src);
		byte[] decodeByte = Base64.decode(src);
		byte[] decodeByteUtf8 = Base64.decode(src.getBytes("UTF-8"), 0, src.length());
		System.out.println("decodeString: " + decodeString);
		System.out.println("decodeByte: " + decodeByte);
		System.out.println("decodeByteUtf8: " + decodeByteUtf8);
	}
	
	public static void encode(String src) throws UnsupportedEncodingException {
		String encodeString = Base64.encodeString(src);
		String encodeByte = Base64.encodeBytes(src.getBytes());
		String encodeByteUtf8 = Base64.encodeBytes(src.getBytes("UTF-8"));
		System.out.println("encodeString: " + encodeString);
		System.out.println("encodeByte: " + encodeByte);
		System.out.println("encodeByteUtf8: " + encodeByteUtf8);
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String src = "abcab";
		encode(src);
		String srcCode = "YWJjYWI=";
		decode(srcCode);
	}
}
