package com.crazy.chapter15;

import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesTest2 {

	private static final String PATH = "D:\\Program\\workspace-kepler\\CrazyJava\\src\\com\\crazy\\chapter15\\";

	public static void main(String[] args) throws Exception {
		Path path = Paths.get("a.txt");
		Files.copy(path, new FileOutputStream("poem.txt"));
		System.out.println("a.txt是否是隐藏文件：" + Files.isHidden(path));
		List<String> lines = Files.readAllLines(path, Charset.forName("gbk"));
		for (String line : lines) {
			System.out.println(line);
		}
		List<String> aTxt = new ArrayList<>();
		aTxt.add("窗前明月光");
		aTxt.add("疑是地上霜");
		Files.write(path, aTxt, Charset.forName("gbk"));

	}
}
