package com.crazy.chapter15.duplicate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class InsertContent {

	public static void insert(String fileName, long pos, String insertContent)
			throws IOException {
		File tmp = File.createTempFile("tmp", null);
		tmp.deleteOnExit();
		try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
				FileInputStream fis = new FileInputStream(tmp);
				FileOutputStream fos = new FileOutputStream(tmp);) {
			raf.seek(pos);
			byte[] buf = new byte[1024];
			int hasRead = 0;
			while ((hasRead = raf.read(buf)) > 0) {
				fos.write(buf, 0, hasRead);
			}
			raf.seek(pos);
			raf.write(insertContent.getBytes());
			while ((hasRead = fis.read(buf)) > 0) {
				raf.write(buf, 0, hasRead);
			}

		}
	}

	public static void main(String[] args) throws IOException {
		insert(Constants.basicPath + "InsertContent.java", 45,
				"插入的内容\r\n");
	}
}
