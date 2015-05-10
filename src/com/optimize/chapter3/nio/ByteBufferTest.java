package com.optimize.chapter3.nio;

import java.nio.ByteBuffer;

public class ByteBufferTest {

	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocate(15);
		System.out.println("limit=" + bb.limit() + " capacity=" + bb.capacity()
				+ " position=" + bb.position());
		for (int i = 0; i < 10; i++) {
			bb.put((byte) i);
		}
		System.out.println("limit=" + bb.limit() + " capacity=" + bb.capacity()
				+ " position=" + bb.position());
		bb.flip();
		for (int i = 0; i < 5; i++) {
			System.out.print(bb.get());
		}
		System.out.println();
		System.out.println("limit=" + bb.limit() + " capacity=" + bb.capacity()
				+ " position=" + bb.position());
		bb.flip();
		System.out.println("limit=" + bb.limit() + " capacity=" + bb.capacity()
				+ " position=" + bb.position());
	}
}
