package com.crazy.chapter15;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

	public static void main(String[] args) {
		Path path = Paths.get(".");
		System.out.println("path里包含的路径数量：" + path.getNameCount());
		System.out.println("path的根路径：" + path.getRoot());
		Path absolutePath = path.toAbsolutePath();
		System.out.println(absolutePath);

		System.out.println(absolutePath.getRoot());
		System.out.println(absolutePath.getNameCount());
		System.out.println(absolutePath.getName(3));

		Path path2 = Paths.get("g:", "publish", "codes");
		System.out.println(path2);
	}
}
