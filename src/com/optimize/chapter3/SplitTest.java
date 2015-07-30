package com.optimize.chapter3;

import java.util.StringTokenizer;

public class SplitTest {

	public static void main(String[] args) {
		String abc = "a;b,c:d";
		String[] d = abc.split("[;|,|:]");
		for (int i = 0; i < d.length; i++) {
			System.out.println(d[i]);
		}
		Long start = System.currentTimeMillis();
		String orgStr = null;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10000; i++) {
			sb.append("a");
			sb.append(";");
		}
		orgStr = sb.toString();
		for (int i = 0; i < 10000; i++) {
			orgStr.split(";");
		}
		System.out.println(System.currentTimeMillis() - start);
		
		start = System.currentTimeMillis();
		StringTokenizer st = new StringTokenizer(orgStr, ";");
		for (int i = 0; i < 10000; i++) {
			while (st.hasMoreTokens()) {
				st.nextToken();
			}
//			st = new StringTokenizer(orgStr, ";");
		}
		System.out.println(System.currentTimeMillis() - start);
		
		start = System.currentTimeMillis();
		String tmp = orgStr;
		System.out.println(tmp);
		for (int i = 0; i < 10000; i++) {
			while(true) {
				String splitStr = null;
				int j = tmp.indexOf(";");
				if (j < 0) break;
				splitStr = tmp.substring(0, j);
				tmp = tmp.substring(j + 1);
//				System.out.println(splitStr);
			}
			tmp = orgStr;
		}
		System.out.println(System.currentTimeMillis() - start);
		
		String s = "abcd";
		String[] sarr = s.split(",");
		System.out.println("sarr " + sarr.length);
	}
}
