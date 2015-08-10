package com.crazy.chapter15.duplicate.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

import com.crazy.chapter15.duplicate.Constants;

public class ReadFile {

	public static void main(String[] args) throws IOException {
		try (FileInputStream fis = new FileInputStream(Constants.basicPath
				+ "nio/ReadFile.java");
				FileChannel channel = fis.getChannel()) {
			ByteBuffer buffer = ByteBuffer.allocate(64);
			while (channel.read(buffer) != -1) {
				buffer.flip();
				Charset charset = Charset.forName("GBK");
				CharsetDecoder decoder = charset.newDecoder();
				CharBuffer charBuffer = decoder.decode(buffer);
				System.out.print(charBuffer);
				buffer.clear();
			}
		}
	}
}
