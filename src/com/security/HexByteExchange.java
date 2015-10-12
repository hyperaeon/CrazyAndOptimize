package com.security;

public class HexByteExchange {

	private static final char[] LOOK_UP = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
		'e', 'f' };
	
	public static byte[] hexStrToBytes(String s) {
		byte[] bytes = new byte[s.length() >> 1];
		for (int i = 0; i < bytes.length; i++) {
			//Integer.parseInt("12",16),means 1 * 16 + 2 = 18, change to byte=00010010
			bytes[i] = (byte) Integer.parseInt(s.substring(i << 1, (i << 1) + 2), 16);
		}
		return bytes;
	}
	
	public static String byte2HexStr(byte[] bytes) {
		StringBuilder sb = new StringBuilder(bytes.length << 1);
		for (int i = 0; i < bytes.length; i++) {
			sb.append(LOOK_UP[(bytes[i] >>> 4) & 0x0f]);
			sb.append(LOOK_UP[bytes[i] & 0x0f]);
		}
		return sb.toString();
	}
	
	public static String byteToHexStr(byte[] bytes) {
		StringBuffer sb = new StringBuffer(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			sb.append(LOOK_UP[(bytes[i] >>> 4) & 0x0f]);//byte中的高4位
			sb.append(LOOK_UP[bytes[i] & 0x0f]);//byte中的低4位
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String hexStr = "12ae3";
		byte[] bytes = hexStrToBytes(hexStr);
		for (byte b : bytes) {
			System.out.print(b + " ");
		}
		System.out.println();
		
		System.out.println("byteToHexStr: " + byteToHexStr(bytes));
		
		System.out.println((byte)Integer.parseInt("12", 16));
		
		System.out.println("30819f300d06092a864886f70d010101050003818d003081890281810087078d1a8f8b391772a75751e15b96fb9ff0d8b831b0e66af01eec35e099c572c5f803b45b0f351582a15ae2bf4b6594d3cdf9ec35c7a319e6e0258f618a0054a29d9aaa74b2d700342a772724ab493faca652d5da332eee7248098b584a9628277ac385d1e820e50e2e9a0f4e1e3bcd92df17f9ad8b27eaf90d7b846f78ee550203010001".length());
	}
}
