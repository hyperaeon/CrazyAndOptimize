package com.optimize.chapter3.nio;

import java.nio.ByteBuffer;

public class MarkTest {

	public static void main(String[] args) {
		ByteBuffer b = ByteBuffer.allocate(15);
		for (int i = 0; i < 10; i++) {
			b.put((byte) i);
		}
		b.flip();
		for (int i = 0; i < b.limit(); i++) {
			System.out.print(b.get());
			if (i == 4) {
				b.mark();
				System.out.print("(mark at " + i + ")");
			}
		}
		b.reset();
		System.out.println("\nreset to mark");
		while (b.hasRemaining()) {
			System.out.print(b.get());
		}
		System.out.println();
		
	}
}
