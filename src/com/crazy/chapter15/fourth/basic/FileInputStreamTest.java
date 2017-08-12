package com.crazy.chapter15.fourth.basic;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {
	
	private static final String PATH = "C:\\Users\\hzliyong\\git\\CrazyAndOptimize\\src\\com\\crazy\\chapter15\\fourth\\basic\\FileInputStreamTest.java";
		
	public static void main(String[] args) throws IOException {
		try (FileInputStream fis = new FileInputStream(PATH)) {
			//创建长度为1024的“竹筒”
			byte[] buf = new byte[1024];
			int hasRead = 0;
			while ((hasRead = fis.read(buf)) > 0) {
				System.out.println(new String(buf, 0, hasRead));
			}
		}
	}

}
