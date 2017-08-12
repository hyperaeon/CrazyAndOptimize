package com.crazy.chapter15.fourth.basic;

import java.io.File;

public class FilenameFilterTest {

	public static void main(String[] args) {
		File file = new File(".");
		String[] nameList = file.list((File dir, String name) -> {
			return name.endsWith(".java")
					|| new File(name).isDirectory();
		});
		for (String name : nameList) {
			System.out.println(name);
		}
	}
}
