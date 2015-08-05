package com.optimize.chapter3.trip;

import java.util.StringTokenizer;

public class SplitTest {

	public static void main(String[] args) {
		String orgStr = getOrgStr();
		// splitTest(orgStr);
//		stringTokenizerTest(orgStr);
		customizeTest(orgStr);
	}

	private static String getOrgStr() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 1000; i++) {
			sb.append(i);
			sb.append(";");
		}
		return sb.toString();
	}

	private static void splitTest(String orgStr) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			orgStr.split(";");
		}
		System.out.println("Split waste: "
				+ (System.currentTimeMillis() - start));
	}

	private static void stringTokenizerTest(String orgStr) {
		long start = System.currentTimeMillis();
		StringTokenizer st = new StringTokenizer(orgStr, ";");
		for (int i = 0; i < 10000; i++) {
			while (st.hasMoreTokens()) {
				st.nextToken();
			}
			st = new StringTokenizer(orgStr, ";");
		}
		System.out.println("StringTokenizer waste: "
				+ (System.currentTimeMillis() - start));
	}

	private static void customizeTest(String orgStr) {
		long start = System.currentTimeMillis();
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
		System.out.println("customizeTest waste: "
				+ (System.currentTimeMillis() - start));
	}
}
