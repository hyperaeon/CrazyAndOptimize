package com.algorithm.classic;

import java.io.UnsupportedEncodingException;

public class ChineseAndEnglishSplit {

	public static void main(String[] args) throws Exception {
		// String source = "我是中国人，ABC是英文字母，也是中文拼音";
		String source = "我ABC汉DEF";
		System.out.println(split(source, 7));
	}

	public static String split(String source, int byteNum)
			throws UnsupportedEncodingException {
		int total = 0;// statistic byte numbers
		StringBuffer buffer = new StringBuffer();// store the output string
		for (int i = 0; i < source.length(); i++) {
			// get the byte array in GBK, if the char is chinese, then the
			// length of b will be 2, otherwise will be 1.
			byte[] b = String.valueOf(source.charAt(i)).getBytes("GBK");
			total += b.length;
			// if byte number bigger then byteNum, then break.
			if (total > byteNum) {
				break;
			}
			buffer.append(source.charAt(i));
		}
		return buffer.toString();
	}
}
