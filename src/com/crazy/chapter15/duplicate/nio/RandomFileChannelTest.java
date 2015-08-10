package com.crazy.chapter15.duplicate.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import com.crazy.chapter15.duplicate.Constants;

public class RandomFileChannelTest {

	public static void main(String[] args) {
		File f = new File(Constants.basicPath + "nio/FileChannelTest.txt");
		try (FileChannel channel = new RandomAccessFile(f, "rw").getChannel();) {
			ByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, f.length());
			channel.position(f.length());
			channel.write(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
