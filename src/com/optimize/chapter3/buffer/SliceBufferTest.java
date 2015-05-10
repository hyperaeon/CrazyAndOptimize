package com.optimize.chapter3.buffer;

import java.nio.ByteBuffer;

public class SliceBufferTest {

	public static void main(String[] args) {
		ByteBuffer b = ByteBuffer.allocate(15);
		for (int i = 0; i < 10; i++) {
			b.put((byte) i);
		}
		b.position(2);
		b.limit(6);
		ByteBuffer subBuffer = b.slice();
		for (int i = 0; i < subBuffer.capacity(); i++) {
			byte bb = subBuffer.get(i);
			bb *= 10;
			subBuffer.put(i, bb);
		}
		b.position(0);
		b.limit(b.capacity());
		while (b.hasRemaining()) {
			System.out.print(b.get() + " ");
		}
	}
}
