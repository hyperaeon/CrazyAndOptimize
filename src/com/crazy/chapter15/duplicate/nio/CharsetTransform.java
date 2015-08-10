package com.crazy.chapter15.duplicate.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class CharsetTransform {

	public static void main(String[] args) throws Exception {
		Charset cn = Charset.forName("GBK");
		CharsetEncoder ce = cn.newEncoder();
		CharsetDecoder cd = cn.newDecoder();
		CharBuffer cb = CharBuffer.allocate(8);
		cb.put('a');
		cb.put('b');
		cb.put('c');
		cb.flip();
		ByteBuffer bb = ce.encode(cb);
		for (int i = 0; i < bb.limit(); i++) {
			System.out.print(bb.get(i) + " ");
		}
		System.out.print("\n" + cd.decode(bb));
	}
}
