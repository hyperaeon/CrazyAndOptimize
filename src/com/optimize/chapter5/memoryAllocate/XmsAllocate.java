package com.optimize.chapter5.memoryAllocate;

import java.util.Vector;

public class XmsAllocate {

	public static void main(String[] args) {
		Vector<byte[]> v = new Vector<>();
		for (int i = 1; i <= 10; i++) {
			byte[] b = new byte[1024 * 1024];
			v.add(b);
			if (v.size() == 3) {
				v.clear();
			}
		}
	}
}
