package com.crazy.chapter15.fourfold;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

	public static void main(String[] args) {
		Path path = Paths.get(".");
		System.out.println("count:" + path.getNameCount());
		System.out.println(path);
		Path absolutePath = path.toAbsolutePath();
		System.out.println(absolutePath.getRoot());
		System.out.println(absolutePath.getNameCount());
		System.out.println(absolutePath.getName(3));
		for (int i = 0; i < absolutePath.getNameCount(); i++) {
			System.out.println(i + ": " + absolutePath.getName(i));
		}
		System.out.println(absolutePath.getFileName());
		
		Path path2 = Paths.get("d:", "home");
		System.out.println(path2);
		System.out.println(path2.getNameCount());
	}
}
