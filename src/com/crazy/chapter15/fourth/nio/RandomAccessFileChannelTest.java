package com.crazy.chapter15.fourth.nio;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class RandomAccessFileChannelTest {

	private static final String PATH = "C:\\Users\\hzliyong\\git\\CrazyAndOptimize\\src\\com\\crazy\\chapter15\\fourth\\nio\\RandomAccessFileChannelTest.java";
	
	public static void main(String[] args) {
		File file = new File(PATH);
		try (RandomAccessFile raf = new RandomAccessFile(file, "rw");
				FileChannel fileChannel = raf.getChannel();) {
			ByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			fileChannel.position(file.length());
			fileChannel.write(buffer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
