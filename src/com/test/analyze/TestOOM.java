package com.test.analyze;

import java.util.ArrayList;
import java.util.List;

public class TestOOM {

	static class Obj {
		public byte[] bytes = "hello oom".getBytes();
	}
	
	public static void main(String[] args) {
		List<Obj> list = new ArrayList<Obj>();
		while (true) {
			list.add(new Obj());
		}
	}
}
