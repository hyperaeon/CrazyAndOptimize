package com.optimize.chapter5.duplicate;

import java.util.Vector;

public class TestXms {

	public static void main(String[] args) {
		Vector v = new Vector();
		for (int i = 1; i <= 10; i++) {
			byte[] b = new byte[1024 * 1024];
			v.add(b);
			if (v.size() == 3) {
				v.clear();
			}
		}
	}
}
