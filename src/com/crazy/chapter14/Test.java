package com.crazy.chapter14;

import java.lang.annotation.Annotation;

public class Test {

	@MyTag()
	public void info(){
		
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, ClassNotFoundException {
		Test test = new Test();
		Annotation[] annotation = test.getClass().getMethod("info").getAnnotations();
		for(Annotation anno : annotation){
			System.out.println(anno);
		}
	}
}
