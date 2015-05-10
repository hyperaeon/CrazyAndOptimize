package com.optimize.chapter3.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ByteBufferRead {

	private static String PATH = "D:\\Program\\workspace-kepler\\CrazyJava\\a.txt";
	
	public static void main(String[] args) throws IOException {
		ByteBuffer bookBuf = ByteBuffer.wrap("geyiming".getBytes("UTF-8"));
		ByteBuffer autBuf = ByteBuffer.wrap("java".getBytes("UTF-8"));
		ByteBuffer[] bufs = new ByteBuffer[]{bookBuf, autBuf};
		File file = new File(PATH);
		if (!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(file);
		FileChannel fc = fos.getChannel();
		fc.write(bufs);
		fc.close();
		fos.close();
		
		ByteBuffer b1 = ByteBuffer.allocate(bookBuf.limit());
		ByteBuffer b2 = ByteBuffer.allocate(autBuf.limit());
		ByteBuffer[] bytes = new ByteBuffer[]{b1, b2};
		FileInputStream fis = new FileInputStream(file);
		FileChannel fcc = fis.getChannel();
		fcc.read(bytes);
		fis.close();
		String bookName = new String(bytes[0].array(), "UTF-8");
		String authName = new String(bytes[1].array(), "UTF-8");
		System.out.println(bookName + " " + authName);
	}
}
