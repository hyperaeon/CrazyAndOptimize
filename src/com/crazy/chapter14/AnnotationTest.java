package com.crazy.chapter14;

import java.lang.annotation.Annotation;


public class AnnotationTest {

	@Testable
	public void info(){
		System.out.println("info·½·¨...");
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException{
		AnnotationTest test = new AnnotationTest();
		Annotation[] annotation = test.getClass().getMethod("info").getAnnotations();
		for(Annotation anno : annotation){
			System.out.println(anno);
		}
	}
}
