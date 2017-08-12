package com.crazy.chapter15.fourth.basic;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	private static final String PATH = "C:\\Users\\hzliyong\\git\\CrazyAndOptimize\\src\\com\\crazy\\chapter15\\fourth\\basic\\RandomAccessFileTest.java";
	
	public static  void main(String[] args) {
		try (RandomAccessFile file = new RandomAccessFile(PATH, "r")) {
			System.out.println("position: " + file.getFilePointer());
			file.seek(300);
			byte[] buf = new byte[1024];
			int hasRead = 0;
			while ((hasRead = file.read(buf)) > 0) {
				System.out.println(new String(buf, 0, hasRead));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
