package com.optimize.chapter5.useful;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import net.sf.cglib.proxy.MethodInterceptor;

import com.optimize.chapter5.JavaBeanObject;
import com.optimize.chapter5.MyClassLoader;

public class TraceClassInstance {

	static MyClassLoader cl = new MyClassLoader();

	static MethodInterceptor mi = new MyMethodInterceptor();

	public static void main(String[] args) throws CannotCompileException,
			InstantiationException, IllegalAccessException, NotFoundException {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			JavaBeanObject v = createInstance2(i);
			cl = new MyClassLoader();
		}
	}

	private static JavaBeanObject createInstance2(int i)
			throws CannotCompileException, InstantiationException,
			IllegalAccessException, NotFoundException {
		CtClass c = ClassPool.getDefault().makeClass("Geym" + i);
		c.setSuperclass(ClassPool.getDefault().get(
				"com.optimize.chapter5.JavaBeanObject"));
		Class clz = c.toClass(cl, null);
		return (JavaBeanObject) clz.newInstance();
	}

}
