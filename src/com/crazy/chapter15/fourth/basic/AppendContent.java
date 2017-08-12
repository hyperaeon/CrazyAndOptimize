package com.crazy.chapter15.fourth.basic;

import java.io.IOException;
import java.io.RandomAccessFile;

public class AppendContent {

	private static final String PATH = "C:\\Users\\hzliyong\\git\\CrazyAndOptimize\\src\\com\\crazy\\chapter15\\fourth\\basic\\AppendContent.java";
	
	public static void main(String[] args) {
		try (RandomAccessFile file = new RandomAccessFile(PATH, "rw")) {
			file.seek(file.length());
			file.write("class Test {}\r\n".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
class Test {}
