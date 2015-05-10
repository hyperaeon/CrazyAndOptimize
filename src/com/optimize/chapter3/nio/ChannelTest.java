package com.optimize.chapter3.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class ChannelTest {

	public static void main(String[] args) throws IOException {
		FileInputStream fin = new FileInputStream(new File("temp.txt"));
		FileChannel fc = fin.getChannel();
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		fc.read(byteBuffer);
		fc.close();
		byteBuffer.flip();
	}
	
	public static void nioCopyFile(String resource, String destination) throws IOException{
		FileInputStream fis = new FileInputStream(resource);
		FileInputStream fos = new FileInputStream(destination);
		
	}
}
