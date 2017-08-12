package com.crazy.chapter15.fourth.basic;

import java.io.StringReader;
import java.io.StringWriter;

public class StringNodeTest {

	public static void main(String[] args) throws Exception {
		String src = "from tomomrrow";
		char[] buffer = new char[32];
		int hasRead = 0;
		try (StringReader sr = new StringReader(src)) {
			while ((hasRead = sr.read()) > 0) {
				System.out.println(new String(buffer, 0, hasRead));
			}
		}
		try (StringWriter sw = new StringWriter()) {
			sw.write("asdfda");
			System.out.println(sw.toString());
		}
	}
}
