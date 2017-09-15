package com.crazy.chapter18.duplicate;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class CreateJFrame {


	public static void main(String[] args) throws Exception {
		Class<?> jframeClazz = Class.forName("javax.swing.JFrame");
		Constructor con = jframeClazz.getConstructor(String.class);
		Object obj = con.newInstance("测试窗口");
		System.out.println(obj);
		String mtdName = "setTitle";
		Method mtd = jframeClazz.getMethod(mtdName, String.class);
		mtd.invoke(obj, "abcde");
		System.out.println(obj);
	}
}
