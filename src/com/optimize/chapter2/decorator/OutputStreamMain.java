package com.optimize.chapter2.decorator;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamMain {

	public static void main(String[] args) throws IOException{
//		DataOutputStream dout = new DataOutputStream(new BufferedOutputStream(
//				new FileOutputStream("C:\\Users\\Oliver\\Desktop\\temp2.txt")));
		DataOutputStream dout = new DataOutputStream(
				new FileOutputStream("C:\\Users\\Oliver\\Desktop\\temp2.txt"));
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			dout.writeLong(i);
		}
		System.out.println("Spend:" + (System.currentTimeMillis() - begin));
	}
}
