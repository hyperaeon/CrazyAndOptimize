package com.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileSplit {

	private static final String SOURCE_PATH = "C:\\Users\\hzliyong\\Documents\\file\\";

	private static final String DESTIN_PATH = "E:\\projects\\";

	private static final int MAX_LINE = 50000;
	
	private static final String CHANGE_LINE = "\r\n";

	public static void main(String[] args) {
		File file = new File(SOURCE_PATH);
		File[] files = file.listFiles();
		System.out.println("");
		for (File f : files) {
			if (!f.isDirectory()) {
				System.out.println(f.getName() + " line count: " + countLine(SOURCE_PATH, f));
				splitFile(f);
			}
		}
	}

	/**
	 * 统计文件行数
	 * 
	 * @param f
	 * @return
	 */
	private static int countLine(String path, File f) {
		RandomAccessFile raf = null;
		int count = 0;
		try {
			raf = new RandomAccessFile(path + f.getName(), "r");
			String line = null;
			while ((line = raf.readLine()) != null) {
				count++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (raf != null) {
				try {
					raf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return count;
	}
	
	/**
	 * 文件分批，一个文件最多有MAX_LINE行
	 * @param path
	 * @param f
	 */
	private static void splitFile(File f) {
		RandomAccessFile raf = null;
		StringBuilder sb = new StringBuilder();
		String wholeFileName = f.getName();
		String fileName = wholeFileName.substring(0, wholeFileName.indexOf("."));
		String ext = wholeFileName.substring(wholeFileName.indexOf("."));
		try {
			raf = new RandomAccessFile(f.getAbsolutePath(), "r");
			String line = null;
			int lineCount = 0;
			int fileCount = 1;
			while ((line = raf.readLine()) != null) {
				line = new String(line.getBytes("ISO-8859-1"), "UTF-8");
				sb.append(line).append(CHANGE_LINE);
				lineCount++;
				if (lineCount >= MAX_LINE || fileCount == 1) {//当文件总行数小于50000或者文件行数超过50000
					RandomAccessFile subFile = new RandomAccessFile(DESTIN_PATH + fileName + fileCount + ext, "rw");
					subFile.write(sb.toString().getBytes("UTF-8"));
					fileCount++;
					lineCount = 0;
					sb = new StringBuilder();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (raf != null) {
				try {
					raf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
