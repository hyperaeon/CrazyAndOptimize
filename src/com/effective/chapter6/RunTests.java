package com.effective.chapter6;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTests {

	public static void main(String[] args) throws Exception {
		int tests = 0;
		int passed = 0;
		Class testClass = Class.forName("com.effective.chapter6.Sample2");
		for (Method m : testClass.getDeclaredMethods()) {
			if (m.isAnnotationPresent(Test.class)) {
				tests++;
				try {
					m.invoke(null);
					// passed++;
				} catch (InvocationTargetException exc) {
					Throwable t = exc.getCause();
					Class<? extends Exception> excType = m.getAnnotation(
							ExceptionTest.class).values();
					if (excType.isInstance(t)) {
						passed++;
					} else {
						System.out.println(m + " failed" + t);
					}
				} catch (Exception e) {
					System.out.println("INVALID @Test" + m);
				}
			}
		}
		System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
	}
}
