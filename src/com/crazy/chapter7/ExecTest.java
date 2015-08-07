package com.crazy.chapter7;

public class ExecTest {

	public static void main(String[] args) throws Exception {
		Runtime rt = Runtime.getRuntime();
		rt.exec("notepad.exe");
	}
}
