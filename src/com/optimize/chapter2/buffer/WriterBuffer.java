package com.optimize.chapter2.buffer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

public class WriterBuffer {

	private static final int CIRCLE = 100000;
	
	public static void main(String[] args) throws Exception {
		Writer writer = new FileWriter(new File("file.txt"));
		long begin = System.currentTimeMillis();
		for (int i = 0; i < CIRCLE; i++) {
			writer.write(i);
		}
		writer.close();
		System.out.println("file write without buffer spend: " + (System.currentTimeMillis() - begin) + "ms");
		writer = new BufferedWriter(new FileWriter(new File("file.txt")));
		begin = System.currentTimeMillis();
		for (int i = 0; i < CIRCLE; i++) {
			writer.write(i);
		}
		writer.close();
		System.out.println("file write without buffer spend: " + (System.currentTimeMillis() - begin) + "ms");
	}
}
