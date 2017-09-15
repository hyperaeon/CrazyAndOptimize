package com.crazy.chapter14.duplicate;

import java.lang.reflect.Method;

public class ProcessorTest {

	public static void process(String clazz) throws ClassNotFoundException {
		int passed = 0;
		int failed = 0;
		for (Method m : Class.forName(clazz).getMethods()) {
			if (m.isAnnotationPresent(Testable.class)) {
				try {
					m.invoke(null);
					passed++;
				} catch (Exception e) {
					System.out.println("test " + m + "failed");
					failed++;
				}
			}
		}
		System.out.println("succ: " + passed + " failed: " + failed);
	}
}
