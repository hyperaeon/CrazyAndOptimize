package com.crazy.chapter18.duplicate.generic;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

class B {
	
}

public class GenericTest {

	private Map<String, Integer> score;
	
	public static void main(String[] args) throws Exception {
		Class<GenericTest> clazz = GenericTest.class;
		Field f = clazz.getDeclaredField("score");
		Class<?> a = f.getType();
		System.out.println("score类型是：" + a);
		Type gType = f.getGenericType();
		if (gType instanceof ParameterizedType) {
			ParameterizedType pType = (ParameterizedType) gType;
			Type rType = pType.getRawType();
			System.out.println("原始类型是：" + rType);
			Type[] tArgs = pType.getActualTypeArguments();
			System.out.println("泛型类型是：");
			for (int i = 0; i < tArgs.length; i++) {
				System.out.println("第" + i + "个泛型类型是：" + tArgs[i]);
			}
		} else {
			System.out.println("wrong");
		}
		System.out.println(Integer.MIN_VALUE);
		B b1 = new B();
		B b2 = new B();
		System.out.println(b1.equals(b2));
	}
}
