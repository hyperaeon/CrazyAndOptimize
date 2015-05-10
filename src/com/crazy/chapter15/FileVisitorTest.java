package com.crazy.chapter15;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class FileVisitorTest {

	public static void main(String[] args) throws Exception {
		Files.walkFileTree(Paths.get("d:", "Program", "workspace-kepler"),
				new SimpleFileVisitor<Path>() {
					@Override
					public FileVisitResult visitFile(Path file,
							BasicFileAttributes attrs) throws IOException {
						System.out.println("���ڷ���" + file + "�ļ�");
						if (file.endsWith("FileVisitorTest.java")) {
							System.out.println("---�Ѿ��ҵ�Ŀ���ļ�---");
							return FileVisitResult.TERMINATE;
						}
						return FileVisitResult.CONTINUE;
					}

					@Override
					public FileVisitResult preVisitDirectory(Path dir,
							BasicFileAttributes attrs) throws IOException {
						System.out.println("���ڷ��ʣ�" + dir + "·��");
						return FileVisitResult.CONTINUE;
					}
				});
	}
}
