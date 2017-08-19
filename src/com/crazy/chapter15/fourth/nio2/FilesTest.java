package com.crazy.chapter15.fourth.nio2;

import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesTest {

	private static final String FILE = "FilesTest.java";
	
	public static void main(String[] args) throws Exception {
		Files.copy(Paths.get(FILE), new FileOutputStream("a.txt"));
		System.out.println("Is hidden: " + Files.isHidden(Paths.get(FILE)));
		List<String> lines = Files.readAllLines(Paths.get(FILE), Charset.forName("GBK"));
		System.out.println(lines);
		System.out.println(Files.size(Paths.get(FILE)));
		List<String> poem = new ArrayList<>();
		poem.add("abcd");
		poem.add("bcd");
		Files.write(Paths.get("poem.txt"), poem, Charset.forName("GBK"));
		FileStore cStore = Files.getFileStore(Paths.get(FILE));
		System.out.println(cStore.getTotalSpace());
		System.out.println(cStore.getUsableSpace());
	}
}
