package com.optimize.chapter5.optimizeCase;

import java.util.Vector;

public class HeapSize {

	public static void main(String[] args) throws InterruptedException {
		Vector v = new Vector();
		while (true) {
			byte[] b = new byte[1024 * 1024];
			v.add(b);
			if (v.size() == 10) {
				v = new Vector();
			}
			Thread.sleep(1);
		}
	}
}
