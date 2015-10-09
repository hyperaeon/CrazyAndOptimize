package com.effective.chapter4;

import java.io.Serializable;
import java.util.Comparator;

public class Host {

	private static class StrLenCmp implements Comparator<String>, Serializable {
		public int compare(String s1, String s2) {
			return s1.length() - s2.length();
		}
	}

	public static final Comparator<String> STRING_LENGTH_COMPARATOR = new StrLenCmp();
}
