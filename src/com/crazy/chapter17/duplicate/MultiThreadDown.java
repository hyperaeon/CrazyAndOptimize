package com.crazy.chapter17.duplicate;

public class MultiThreadDown {

	public static void main(String[] args) throws Exception {
		final DownUtil downUtil = new DownUtil("http://www.crazyit.org/",
				"oraclesql.rar", 4);
	}
}
