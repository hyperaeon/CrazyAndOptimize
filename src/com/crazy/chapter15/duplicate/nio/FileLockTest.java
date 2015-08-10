package com.crazy.chapter15.duplicate.nio;

import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

import com.crazy.chapter15.duplicate.Constants;

public class FileLockTest {

	public static void main(String[] args) throws Exception {
		try (FileChannel channel = new FileOutputStream(Constants.basicPath + "nio/a.txt").getChannel()) {
			FileLock lock = channel.tryLock();
			Thread.sleep(1000);
			lock.release();
		} 
	}
}
