package com.crazy.chapter15.duplicate;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringNodeTest {

	public static void main(String[] args) {
		String src = "asadfasd\n" + "sdfasdf sad\n" + "fsafawe \n";
		char[] cbuf = new char[32];
		int hasRead = 0;
		try (StringReader sr = new StringReader(src)) {
			while ((hasRead = sr.read(cbuf)) > 0) {
				System.out.print(new String(cbuf, 0, hasRead));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (StringWriter sw = new StringWriter()) {
			sw.write("asdfas\n");
			sw.write("sdfasdf\n");
			System.out.println(sw.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
