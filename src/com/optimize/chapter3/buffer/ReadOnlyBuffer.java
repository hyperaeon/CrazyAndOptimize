package com.optimize.chapter3.buffer;

import java.nio.ByteBuffer;

public class ReadOnlyBuffer {

	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(15);
		for (int i = 0; i < 10; i++) {
			buffer.put((byte) i);
		}
		ByteBuffer readOnly = buffer.asReadOnlyBuffer();
		readOnly.flip();
		while (readOnly.hasRemaining()) {
			System.out.print(readOnly.get() + " ");
		}
		System.out.println();
		buffer.put(2, (byte) 20);
		readOnly.flip();
		while (readOnly.hasRemaining()) {
			System.out.print(readOnly.get() + " ");
		}
	}
}
