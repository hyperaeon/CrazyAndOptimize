package com.effective.duplicate.chapter2;

import java.util.concurrent.atomic.AtomicInteger;

import com.effective.chapter3.Point;

public class CounterPoint extends Point {

	private static final AtomicInteger counter = new AtomicInteger();
	
	public CounterPoint(int x, int y) {
		super(x, y);
		counter.incrementAndGet();
	}
	
	public static int numberCreated() {
		return counter.get();
	}
	
	public static void main(String[] args) {
		for (int i = 0 ; i < 100; i++) {
			new CounterPoint(i, i + 1);
		}
		System.out.println(CounterPoint.numberCreated());
	}
}
