package com.crazy.chapter15.fourth.nio;

import java.nio.CharBuffer;
 import static java.lang.System.out;

public class BufferTest {

	public static void main(String[] args) {
		CharBuffer buffer = CharBuffer.allocate(8);
		out.println("capacity:" + buffer.capacity());
		out.println("limit:" + buffer.limit());
		out.println("position:" + buffer.position());
		
		buffer.put('a');
		buffer.put('b');
		buffer.put('c');
		
		out.println("加入3个元素后的position:" + buffer.position());
		buffer.flip();
		out.println("after flip(),limit:" + buffer.limit());
		out.println("after flip(),position:" + buffer.position());
		
		out.println("第一个元素:" + buffer.get());
		out.println("取出第一个元素后,position:" + buffer.position());
		buffer.clear();

		out.println("after clear(),limit:" + buffer.limit());
		out.println("after clear(),position:" + buffer.position());

		out.println("第二个元素:" + buffer.get(6));
		out.println("执行绝对读取后,position:" + buffer.position());
	}
}
