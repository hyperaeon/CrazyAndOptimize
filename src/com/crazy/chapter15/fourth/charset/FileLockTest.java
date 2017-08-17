package com.crazy.chapter15.fourth.charset;

import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockTest {

	public static void main(String[] args) throws Exception {
		try (FileChannel channel = new FileOutputStream("a.txt").getChannel()) {
			FileLock lock = channel.tryLock();
			Thread.sleep(1000);
			lock.release();
		}
	}
}
