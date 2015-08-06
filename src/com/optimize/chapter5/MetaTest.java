package com.optimize.chapter5;

import org.junit.Test;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

public class MetaTest {

	static MyClassLoader cl = new MyClassLoader();
	
	@Test
	public void testOneClassLoad() throws CannotCompileException,
			InstantiationException, IllegalAccessException, NotFoundException {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			CtClass c = ClassPool.getDefault().makeClass("Geym" + i);
			c.setSuperclass(ClassPool.getDefault().get(
					"com.optimize.chapter5.JavaBeanObject"));
//			Class clz = c.toClass();
			Class clz = c.toClass(cl, null);
			JavaBeanObject v = (JavaBeanObject) clz.newInstance();
			if (i % 10 == 0) {
				cl = new MyClassLoader();
			}
		}
	}
}
