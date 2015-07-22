package com.crazy.chapter4;

import java.util.Arrays;

public class Num2Rmb {

	private String[] hanArr = { "Áã", "Ò¼", "·¡", "Èþ", "ËÁ", "Îé", "Â½", "Æâ", "°Æ",
			"¾Á", "Ê°" };

	private String[] unitArr = { "Ê®", "°Ù", "Ç§" };

	private String[] divide(double num) {
		long zheng = (long) num;
		long xiao = Math.round((num - zheng) * 100);
		return new String[] { zheng + "", String.valueOf(xiao) };
	}

	private String toHanStr(String numStr) {
		String result = "";
		int numLen = numStr.length();
		for (int i = 0; i < numLen; i++) {
			int num = numStr.charAt(i) - 48;
			if (i != numLen - 1 && num != 0) {
				result += hanArr[num] + unitArr[numLen - 2 - i];
			} else {
				result += hanArr[num];
			}
		}
		return result;

	}

	public static void main(String[] args) {
		Num2Rmb nr = new Num2Rmb();
		System.out.println(Arrays.toString(nr.divide(2392323.33)));
		System.out.println(nr.toHanStr("5009"));
	}
}
