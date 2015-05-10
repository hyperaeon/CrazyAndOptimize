package com.crazy.chapter15;

import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesTest {

	private static final String PATH = "D:\\Program\\workspace-kepler\\CrazyJava\\src\\com\\crazy\\chapter15\\";

	public static void main(String[] args) throws Exception {
		Files.copy(Paths.get(PATH + "FilesTest.java"), new FileOutputStream(
				"a.txt"));
		System.out.println("FilesTest.java是否为隐藏文件："
				+ Files.isHidden(Paths.get(PATH + "FilesTest.java")));
		List<String> lines = Files.readAllLines(
				Paths.get(PATH + "FilesTest.java"), Charset.forName("gbk"));
		for (String line : lines) {
			System.out.println(line);
		}
		System.out.println("FilesTest.java的大小是："
				+ Files.size(Paths.get(PATH + "FilesTest.java")));
		List<String> poem = new ArrayList<>();
		poem.add("海阔凭鱼跃");
		poem.add("天高任鸟飞");
		Files.write(Paths.get("poem.txt"), poem, Charset.forName("gbk"));
		FileStore cStore = Files.getFileStore(Paths.get("C:"));
		System.out.println("C:共有空间：" + cStore.getTotalSpace());
		System.out.println("C:可以空间：" + cStore.getUsableSpace());

	}
}
