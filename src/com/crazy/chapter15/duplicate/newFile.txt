package com.crazy.chapter15.duplicate;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {

	public static void main(String[] args) throws IOException {
		try (FileInputStream fis = new FileInputStream(Constants.basicPath
				+ "FileOutputStreamTest.java");
				FileOutputStream fos = new FileOutputStream(Constants.basicPath
						+ "newFile.txt")) {
			byte[] buff = new byte[1024];
			int hasRead = 0;
			while ((hasRead = fis.read(buff)) > 0) {
				fos.write(buff, 0, hasRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
