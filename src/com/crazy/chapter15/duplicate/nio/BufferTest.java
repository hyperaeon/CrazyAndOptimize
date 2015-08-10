package com.crazy.chapter15.duplicate.nio;

import static java.lang.System.out;

import java.nio.CharBuffer;

public class BufferTest {

	public static void main(String[] args) {
		CharBuffer buffer = CharBuffer.allocate(8);
		out.println("capacity:" + buffer.capacity());
		out.println("limit:" + buffer.limit());
		out.println("position:" + buffer.position());

		buffer.put('a');
		buffer.put('b');
		buffer.put('c');
		out.println("加入三个元素后 position:" + buffer.position());

		buffer.flip();
		out.println("执行flip后");
		out.println("capacity:" + buffer.capacity());
		out.println("limit:" + buffer.limit());
		out.println("position:" + buffer.position());

		buffer.clear();
		out.println("执行clear后");
		out.println("capacity:" + buffer.capacity());
		out.println("limit:" + buffer.limit());
		out.println("position:" + buffer.position());
		out.println(buffer.get(2));
	}
}
