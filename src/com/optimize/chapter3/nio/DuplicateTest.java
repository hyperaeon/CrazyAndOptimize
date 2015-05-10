package com.optimize.chapter3.nio;

import java.nio.ByteBuffer;

public class DuplicateTest {

	public static void main(String[] args) {
		ByteBuffer b = ByteBuffer.allocate(15);
		for (int i = 0; i < 15; i++) {
			b.put((byte) i);
		}
		ByteBuffer c = b.duplicate();
		System.out.println("After b.duplicate() ");
		System.out.println(b);
		System.out.println(c);
		c.flip();
		System.out.println("After c.flip()");
		System.out.println(b);
		System.out.println(c);
		c.put((byte) 100);
		System.out.println("After c.put((byte) 100)");
		System.out.println("b.get(0)=" + b.get(0));
		System.out.println("c.get(0)=" + c.get(0));
		
	}
}
