package com.optimize.chapter3.duplicate.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelTest {

	public static void main(String[] args) throws IOException {
		FileInputStream fin = new FileInputStream(new File("temp"));
		FileChannel fc = fin.getChannel();
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		fc.read(byteBuffer);
		fin.close();
		byteBuffer.flip();
	}

	public static void nioCopyFile(String resource, String destination)
			throws IOException {
		FileInputStream fin = new FileInputStream(resource);
		FileOutputStream fos = new FileOutputStream(destination);
		FileChannel readChannel = fin.getChannel();
		FileChannel writeChannel = fos.getChannel();
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		while (true) {
			byteBuffer.clear();
			int len = readChannel.read(byteBuffer);
			if (len == -1) {
				break;
			}
			byteBuffer.flip();
			writeChannel.write(byteBuffer);
		}
		readChannel.close();
		writeChannel.close();
		fin.close();
		fos.close();
	}
}
