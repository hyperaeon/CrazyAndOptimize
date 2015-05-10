package com.optimize.chapter3.buffer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedByteBufferTest {

	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(
				"D:\\Program\\workspace-kepler\\CrazyJava\\a.txt", "rw");
		FileChannel fc = raf.getChannel();
		MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0,
				raf.length());
		while (mbb.hasRemaining()) {
			System.out.print((char) mbb.get());
		}
		mbb.put(0, (byte) 57);
		raf.close();
	}
}
