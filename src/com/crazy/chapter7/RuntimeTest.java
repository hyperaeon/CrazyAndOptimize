package com.crazy.chapter7;

public class RuntimeTest {

	public static void main(String[] args) {
		Runtime run = Runtime.getRuntime();
		System.out.println(run.availableProcessors());
		System.out.println(run.freeMemory());
		System.out.println(run.totalMemory());
		System.out.println(run.maxMemory());
	}
}
