package com.optimize.chapter5.memoryAllocate;


import com.optimize.chapter5.JavaBeanObject;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

public class PersistTestTest {

	
	public static void main(String[] args) throws CannotCompileException,
			InstantiationException, IllegalAccessException, NotFoundException {
		int i = 0;
		
		try {
			for (i = 1; i < Integer.MAX_VALUE; i++) {
				CtClass c = ClassPool.getDefault().makeClass("Geym" + i);
				c.setSuperclass(ClassPool.getDefault().get(
						"com.optimize.chapter5.JavaBeanObject"));
				Class clz = c.toClass();
				JavaBeanObject v = (JavaBeanObject) clz.newInstance();
			}
		} catch (Throwable e) {
			System.out.println("Create new classes count is " + i);
			e.printStackTrace();
		}
	}
}
