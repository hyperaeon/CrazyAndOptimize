package com.crazy.chapter10;

import java.io.FileInputStream;
import java.io.IOException;

public class OverrideThrows {
	public void test() throws IOException {
		FileInputStream fis = new FileInputStream("a.txt");
	}
}

class Sub extends OverrideThrows {
//	public void test() throws Exception {
//		
//	}
}
