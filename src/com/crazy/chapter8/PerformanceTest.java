package com.crazy.chapter8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class PerformanceTest {

	public static void main(String[] args){
		String[] tst1 = new String[900000];
		for(int i = 0; i < 900000; i ++){
			tst1[i] = String.valueOf(i);
		}
		ArrayList<String> a1 = new ArrayList<>();
		for(int i = 0;i < 900000; i ++){
			a1.add(tst1[i]);
		}
		LinkedList<String> l1 = new LinkedList<>();
		for(int i = 0;i < 900000; i ++){
			l1.add(tst1[i]);
		}
		long start = System.currentTimeMillis();
		for(Iterator<String> it = a1.iterator(); it.hasNext();){
			it.next();
		}
		System.out.println("ArrayList遍历用时：" +
				(System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		for(Iterator<String> it = l1.iterator(); it.hasNext();){
			it.next();
		}
		System.out.println("LinkedList遍历用时：" +
				(System.currentTimeMillis() - start));
		
	}
}
