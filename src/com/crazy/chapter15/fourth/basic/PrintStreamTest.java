package com.crazy.chapter15.fourth.basic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamTest {

	private static final String PATH = "C:\\Users\\hzliyong\\git\\CrazyAndOptimize\\src\\main\\resources\\file\\test.txt";
			
	public static void main(String[] args) {
		try (FileOutputStream fos = new FileOutputStream(PATH);
				PrintStream ps = new PrintStream(fos)) {
			ps.println("普通字符串");
			ps.println(new PrintStreamTest());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
