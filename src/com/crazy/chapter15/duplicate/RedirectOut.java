package com.crazy.chapter15.duplicate;

import java.io.IOException;
import java.io.PrintStream;

public class RedirectOut {

	public static void main(String[] args) {
		try (PrintStream ps = new PrintStream(Constants.basicPath
				+ "RedirectOut.txt")) {
			System.setOut(ps);
			System.out.println("普通字符串");
			System.out.println(new RedirectOut());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
