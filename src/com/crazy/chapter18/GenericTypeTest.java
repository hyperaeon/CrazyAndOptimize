package com.crazy.chapter18;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericTypeTest {

	List<String> list = new ArrayList<String>();
	Map<String, Object> map = new HashMap<String, Object>();

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		Map<String, Object> map = new HashMap<String, Object>();
		/*
		 * getGenericType(list.getClass()); getGenericType(map.getClass());
		 */
		// getFieldGenericType();
		getFeildGenericType(GenericTypeTest.class);
	}

	public static void getGenericType(Class<?> clazz) {
		Type superClass = clazz.getGenericSuperclass();
		if (superClass instanceof ParameterizedType) {
			Type[] types = ((ParameterizedType) superClass)
					.getActualTypeArguments();
			Type raw = ((ParameterizedType) superClass).getRawType();
			System.out.println("raw type: " + raw.toString());
			System.out.println("actual types : " + types[0]);
		}
	}

	public static void getFieldGenericType() {
		Field[] fs = GenericTypeTest.class.getDeclaredFields();
		for (Field f : fs) {
			Type fieldType = (Type) f.getGenericType();
			if (fieldType instanceof ParameterizedType) {
				Type rawType = ((ParameterizedType) fieldType).getRawType();
				System.out.println("raw type: " + rawType.toString());
				Type[] types = ((ParameterizedType) fieldType)
						.getActualTypeArguments();
				for (int i = 0; i < types.length; i++) {
					System.out.println(types[i]);
				}

			}
		}
	}

	public static void getFeildGenericType(Class<?> clazz) {
		Field[] fs = clazz.getDeclaredFields();
		for (Field f : fs) {
			Type type = f.getGenericType();
			if (type instanceof ParameterizedType) {
				Type rawType = ((ParameterizedType) type).getRawType();
				System.out.println("rawType: " + rawType.toString());
				Type[] actualTypes = ((ParameterizedType) type)
						.getActualTypeArguments();
				for (Type t : actualTypes) {
					System.out.println("actual type : " + t.toString());
				}
			}
		}
	}
}
