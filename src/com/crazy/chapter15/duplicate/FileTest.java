package com.crazy.chapter15.duplicate;

import java.io.File;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) throws IOException {
		File file = new File(".");
		System.out.println(file.getName());
		System.out.println(file.getParent());
		System.out.println(file.getAbsoluteFile());
		System.out.println(file.getAbsoluteFile().getParent());
		File tempFile = File.createTempFile("bbb", ".txt", file);
		tempFile.deleteOnExit();
		File newFile = new File(System.currentTimeMillis() + "");
		System.out.println("newFile独享是否存在：" + newFile.exists());
		newFile.createNewFile();
		newFile.mkdir();
		String[] fileList = file.list();
		System.out.println("---当前路径下的文件--");
		for (String f : fileList) {
			System.out.println(f);
		}
		File[] roots = File.listRoots();
		System.out.println("---所有根路径--");
		for (File f : roots) {
			System.out.println(f);
		}
	}
}
