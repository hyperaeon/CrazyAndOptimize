package com.crazy.chapter15.duplicate;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	public static void main(String[] args) {
		try (RandomAccessFile raf = new RandomAccessFile(new File(
				Constants.basicPath + "RandomAccessFileTest.java"), "r")) {
			System.out.println("First pos: " + raf.getFilePointer());
			byte[] buff = new byte[1024];
			int hasRead = 0;
			raf.seek(300);
			while ((hasRead = raf.read(buff)) > 0) {
				System.out.print(new String(buff, 0, hasRead));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
