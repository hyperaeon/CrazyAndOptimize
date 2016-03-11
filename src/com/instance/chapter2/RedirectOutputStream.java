package com.instance.chapter2;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class RedirectOutputStream {

	public static void main(String[] args) throws Exception {
		try {
			PrintStream out = System.out;
			PrintStream ps = new PrintStream("./log.txt");
			System.setOut(ps);
			int age = 19;
			System.out.println("nian ling 19");
			String sex = "female";
			System.out.println("sex female");
			String info = "this is a " + sex + " age is " + age;
			System.out.println("integretion " + info);
			System.setOut(out);
			System.out.println("Print log over");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
