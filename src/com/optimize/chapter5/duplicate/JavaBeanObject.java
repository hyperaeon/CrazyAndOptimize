package com.optimize.chapter5.duplicate;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

public class JavaBeanObject {

	private String name = "java";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public static void main(String[] args) throws CannotCompileException, InstantiationException, 
	IllegalAccessException, NotFoundException {
		testOneClassLoad();
	}
	
	public static void testOneClassLoad() throws CannotCompileException, InstantiationException, 
		IllegalAccessException, NotFoundException {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			CtClass c = ClassPool.getDefault().makeClass("Geym" + i);
			c.setSuperclass(ClassPool.getDefault().get("com.optimize.chapter5.duplicate.JavaBeanObject"));
			Class clz = c.toClass();
			JavaBeanObject v = (JavaBeanObject)clz.newInstance();
		}
	}
}
