package com.crazy.chapter14;

import java.lang.annotation.Annotation;

public class TestAnnotation {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, ClassNotFoundException {
		Annotation[] array = Class.forName("Test").getMethod("info").getAnnotations();
		for(Annotation anno : array){
			System.out.println(anno);
		}
	}

}
