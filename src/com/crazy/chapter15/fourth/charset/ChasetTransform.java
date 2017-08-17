package com.crazy.chapter15.fourth.charset;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class ChasetTransform {

	public static void main(String[] args) throws Exception {
		Charset cn = Charset.forName("GBK");;
		CharsetEncoder cnEncoder = cn.newEncoder();
		CharsetDecoder cnDecoder = cn.newDecoder();
		CharBuffer cbuffer = CharBuffer.allocate(8);
		cbuffer.put('孙');
		cbuffer.put('悟');
		cbuffer.put('空');
		cbuffer.flip();
		ByteBuffer bbuff = cnEncoder.encode(cbuffer);
		for (int i = 0; i < bbuff.capacity(); i++) {
			System.out.println(bbuff.get(i) + " ");
		}
		System.out.println("\n" + cnDecoder.decode(bbuff));
	}
}
