package com.crazy.chapter15.fourth.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class InsertContent {
	
	private static final String PATH = "C:\\Users\\hzliyong\\git\\CrazyAndOptimize\\src\\com\\crazy\\chapter15\\fourth\\basic\\InsertContent.java";
	
	public static void main(String[] args) throws IOException {
		insertContent(PATH, 45, "insert content at postion;");
	}
	
	public static void insertContent(String fileName, int pos, String content) throws IOException {
		File file = File.createTempFile("tmp", null);
		file.deleteOnExit();
		try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
				FileInputStream fis = new FileInputStream(file);
				FileOutputStream fos = new FileOutputStream(file);) {
			raf.seek(pos);
			byte[] buff = new byte[1024];
			int hasRead = 0;
			while ((hasRead = raf.read(buff)) > 0) {
				fos.write(buff, 0, hasRead);
			}
			raf.seek(pos);
			raf.write(content.getBytes());
			while ((hasRead = fis.read(buff)) > 0) {
				raf.write(buff, 0, hasRead);
			}
		}
	}
}
