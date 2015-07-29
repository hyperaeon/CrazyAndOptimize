package com.crazy.chapter15.duplicate;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamTest {

	public static void main(String[] args) {
		try (FileOutputStream fos = new FileOutputStream(Constants.basicPath
				+ "test.txt");
				PrintStream ps = new PrintStream(fos)) {
			ps.println("ÆÕÍ¨×Ö·û´®");
			ps.println(new PrintStreamTest());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
