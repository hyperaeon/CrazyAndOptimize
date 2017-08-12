package com.crazy.chapter15.fourth.basic;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	private static final String path = "C:\\Users\\hzliyong\\git\\CrazyAndOptimize\\src\\com\\crazy\\chapter15\\fourth\\basic\\FileReaderTest.java";
	
	public static void main(String[] args) throws IOException {
		try (FileReader reader = new FileReader(path)) {
			char[] buf = new char[64];
			int hasRead = 0;
			while ((hasRead = reader.read(buf)) > 0) {
				System.out.println(new String(buf, 0, hasRead));
			}
		}
	}
}
