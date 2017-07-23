package com.optimize.chapter5.duplicate;

import javassist.ClassPool;
import javassist.CtClass;

public class PermanentTest {

	public static void main(String[] args) {
		int i = 0;
		try {
			for (i = 1; i <= Integer.MAX_VALUE; i++) {
				CtClass c = ClassPool.getDefault().makeClass("Geym" + i);
				c.setSuperclass(ClassPool.getDefault().get("com.optimize.chapter5.duplicate.JavaBeanObject"));
				Class clz = c.toClass();
				JavaBeanObject v = (JavaBeanObject)clz.newInstance();
				v.getName();
			}
		} catch (Throwable e) {
			System.out.println("Create new classes count is " + i);
			e.printStackTrace();
		}
	}
}
