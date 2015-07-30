package com.crazy.chapter15.duplicate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInpustreamTest {

	public static void main(String[] args) throws IOException {
		File file = new File("");
		FileInputStream fis = new FileInputStream(file.getAbsolutePath() + "/src/com/crazy/chapter15/duplicate/FileInpustreamTest.java");
		byte[] buff = new byte[1024];
		int hasRead = 0;
		while ((hasRead = fis.read(buff)) > 0) {
			System.out.print(new String(buff, 0, hasRead));
		}
		fis.close();
	}
}
