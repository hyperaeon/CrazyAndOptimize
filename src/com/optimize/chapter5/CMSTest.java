package com.optimize.chapter5;

import java.util.ArrayList;
import java.util.List;

import com.crazy.chapter8.Student;

public class CMSTest {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 100000; i++) {
			new Student();
		}
		System.gc();
		System.runFinalization();
		System.out.println(list);
	}
}
