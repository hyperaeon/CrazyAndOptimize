package com.crazy.chapter15.duplicate.nio2;

import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.crazy.chapter15.duplicate.Constants;

public class FilesTest {

	public static void main(String[] args) throws Exception {
		Path path = Paths.get(Constants.basicPath + "nio2/FilesTest.java");
		Files.copy(path, new FileOutputStream(Constants.basicPath + "nio2/a.txt"));
		System.out.println("FilesTest.java是否为隐藏文件：" + Files.isHidden(path));
//		List<String> lines = Files.readAllLines(path, Charset.forName("gbk"));
//		System.out.println(lines);
		System.out.println("FilesTest.java的大小为：" + Files.size(path));
		List<String> poem = new ArrayList<String>();
		poem.add("水晶潭底银鱼跃");
		poem.add("清徐风中碧竿横");
		Files.write(Paths.get(Constants.basicPath + "nio2/poem.txt"), poem, Charset.forName("UTF-8"));
		FileStore cStore = Files.getFileStore(Paths.get("C:"));
		System.out.println("C:共有空间：" + cStore.getTotalSpace());
		System.out.println("C:可用空间：" + cStore.getUnallocatedSpace());
	}
}
