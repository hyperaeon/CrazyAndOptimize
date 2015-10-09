package com.security;

public class Exchange {

	public static byte[] hexStrToBytes(String s) {
		byte[] bytes = new byte[s.length() >> 1];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) Integer.parseInt(s.substring(2 * i, 2 * i + 2), 16);
		}
		return bytes;
	}
	
	public static void main(String[] args) {
		String hexStr = "12ae";
		byte[] bytes = hexStrToBytes(hexStr);
		for (byte b : bytes) {
			System.out.print(b + " ");
		}
	}
}
