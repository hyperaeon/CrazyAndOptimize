package com.crazy.chapter15.fourth.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ReadFileTest {

	private static final String PATH = "C:\\Users\\hzliyong\\git\\CrazyAndOptimize\\src\\com\\crazy\\chapter15\\fourth\\nio\\ReadFileTest.java";
	
	public static void main(String[] args) throws IOException {
		try (FileInputStream fis = new FileInputStream(PATH);
				FileChannel fcin = fis.getChannel();) {
			ByteBuffer buffer = ByteBuffer.allocate(64);
			Charset charset = Charset.forName("GBK");
			CharsetDecoder decoder = charset.newDecoder();
			while (fcin.read(buffer) != -1) {
				buffer.flip();
				CharBuffer charBuffer = decoder.decode(buffer);
				System.out.println(charBuffer);
				buffer.clear();
			}
		}
	}
	
}
