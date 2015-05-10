package com.crazy.chapter15;

import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockTest1 {

	public static void main(String[] args) throws Exception {
		FileChannel fileChannel = new FileOutputStream("a.txt").getChannel();
		FileLock fileLock = fileChannel.tryLock();
		FileChannel fileChannel2 = new FileOutputStream("a.txt").getChannel();
		FileLock fileLock2 = fileChannel.tryLock();
		System.out.println(fileLock2);
		Thread.sleep(10000);
		fileLock.release();
	}
}
