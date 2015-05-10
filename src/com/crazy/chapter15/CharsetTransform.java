package com.crazy.chapter15;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class CharsetTransform {

	public static void main(String[] args) throws Exception {
		Charset charset = Charset.forName("GBK");
		CharsetEncoder encoder = charset.newEncoder();
		CharsetDecoder decoder = charset.newDecoder();
		CharBuffer charBuffer = CharBuffer.allocate(8);
		charBuffer.put('a');
		charBuffer.put('b');
		charBuffer.put('c');
		charBuffer.flip();
		ByteBuffer byteBuffer = encoder.encode(charBuffer);
		for (int i = 0; i < byteBuffer.limit(); i++) {
			System.out.println(byteBuffer.get(i));
		}
		System.out.println("charBuffer: " + decoder.decode(byteBuffer));
	}
}
