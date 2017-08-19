package com.crazy.chapter15.fourth.nio2;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;


public class FileVisitorTest {
	
	public static void main(String[] args) throws Exception {
		Files.walkFileTree(Paths.get("C:", "Users", "hzliyong", "git"), new SimpleFileVisitor<Path>() {
			
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				System.out.println("current file: " + file);
				if (file.endsWith("FileVisitorTest.java")) {
					System.out.println("urake");
					return FileVisitResult.TERMINATE;
				}
				return FileVisitResult.CONTINUE;
			}
			
			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
				System.out.println("current dir: " + dir);
				return FileVisitResult.CONTINUE;
			}
		});
		
	}
}
