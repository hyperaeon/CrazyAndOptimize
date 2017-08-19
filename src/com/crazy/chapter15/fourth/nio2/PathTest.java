package com.crazy.chapter15.fourth.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

	public static void main(String[] args) throws Exception {
		Path path = Paths.get(".");
		System.out.println("current path count: " + path.getNameCount());
		Path absolutePath = path.toAbsolutePath();
		System.out.println(absolutePath);
		System.out.println("current root path: " + absolutePath.getRoot());
		Path path2 = Paths.get("D:", "Doc");
		System.out.println(path2.getNameCount());
	}
}
