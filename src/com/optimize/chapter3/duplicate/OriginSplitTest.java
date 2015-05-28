package com.optimize.chapter3.duplicate;

import java.util.StringTokenizer;

public class OriginSplitTest {

	public static void main(String[] args) {
		OriginSplitTest test = new OriginSplitTest();
		String orgStr = null;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 1000; i++) {
			sb.append(i);
			sb.append(";");
		}
		orgStr = sb.toString();

		long start = System.currentTimeMillis();
//		test.orgSplitTest(orgStr);
//		System.out.println("orgSplitTest()  waste time: "
//				+ (System.currentTimeMillis() - start) + " ms");

//		start = System.currentTimeMillis();
//		test.stringTokenizerTest(orgStr);
//		System.out.println("stringTokenizerTest()  waste time: "
//				+ (System.currentTimeMillis() - start) + " ms");
		
//		start = System.currentTimeMillis();
//		test.selfSplitTest(orgStr);
//		System.out.println("selfSplitTest()  waste time: "
//				+ (System.currentTimeMillis() - start) + " ms");
		
		start = System.currentTimeMillis();
		test.charAtTest(orgStr);
		System.out.println("charAtTest()  waste time: "
				+ (System.currentTimeMillis() - start) + " ms");
		
		start = System.currentTimeMillis();
		test.withTest(orgStr);
		System.out.println("withTest()  waste time: "
				+ (System.currentTimeMillis() - start) + " ms");
	}

	public void orgSplitTest(String orgStr) {
		for (int i = 0; i < 10000; i++) {
			orgStr.split(";");
		}
	}

	public void stringTokenizerTest(String orgStr) {
		StringTokenizer st = new StringTokenizer(orgStr, ";");
		for (int i = 0; i < 10000; i++) {
			while (st.hasMoreTokens()) {
				st.nextToken();
			}
			st = new StringTokenizer(orgStr, ";");
		}
	}

	public void selfSplitTest(String orgStr) {
		String tmp = orgStr;
		for (int i = 0; i < 10000; i++) {
			while (true) {
				String splitStr = null;
				int j = tmp.indexOf(';');
				if (j < 0) {
					break;
				}
				splitStr = tmp.substring(0, j);
				tmp = tmp.substring(j + 1);
			}
			tmp = orgStr;
		}
	}
	
	public void charAtTest(String orgStr) {
		int len = orgStr.length();
		if (orgStr.charAt(0) == 'a'
				&& orgStr.charAt(1) == 'b'
				&& orgStr.charAt(2) == 'c') {
			
		}
		if (orgStr.charAt(len - 3) == 'a'
				&& orgStr.charAt(len - 2) == 'b'
				&& orgStr.charAt(len - 1) == 'c') {
			
		}
	}
	
	public void withTest(String orgStr) {
		if (orgStr.startsWith("abc")) {
			
		}
		if (orgStr.endsWith("abc")) {
			
		}
	}
}
