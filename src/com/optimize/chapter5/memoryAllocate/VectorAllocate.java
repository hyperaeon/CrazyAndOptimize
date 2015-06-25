package com.optimize.chapter5.memoryAllocate;

import java.util.Vector;

public class VectorAllocate {

	public static void main(String[] args) {
		Vector<byte[]> v = new Vector<>();
		for (int i = 1; i <= 10; i++) {
			byte[] b = new byte[1024 * 1024];
			v.add(b);
			System.out.println(i + "M is allocated");
		}
		System.out.println("Max memeory : " + Runtime.getRuntime().maxMemory()
				/ 1024 / 1024 + "M");
	}
}
