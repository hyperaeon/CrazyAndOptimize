package com.crazy.chapter15;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

	public static void main(String[] args) {
		Path path = Paths.get(".");
		System.out.println("path�������·��������" + path.getNameCount());
		System.out.println("path�ĸ�·����" + path.getRoot());
		Path absolutePath = path.toAbsolutePath();
		System.out.println(absolutePath);

		System.out.println(absolutePath.getRoot());
		System.out.println(absolutePath.getNameCount());
		System.out.println(absolutePath.getName(3));

		Path path2 = Paths.get("g:", "publish", "codes");
		System.out.println(path2);
	}
}
