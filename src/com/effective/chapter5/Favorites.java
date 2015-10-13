package com.effective.chapter5;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.HashMap;
import java.util.Map;

public class Favorites {

	private Map<Class<?>, Object> favorites = new HashMap<>();

	public <T> void putFavorite(Class<T> type, T instance) {
		if (type == null) {
			throw new NullPointerException("type is null");
		}
		// 动态转换instance
		favorites.put(type, type.cast(instance));
	}

	public <T> T getFavorite(Class<T> type) {
		return type.cast(favorites.get(type));
	}

	public static Annotation getAnnotation(AnnotatedElement element,
			String annotationTypeName) {
		Class<?> annotationType = null;
		try {
			annotationType = Class.forName(annotationTypeName);
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
		return element.getAnnotation(annotationType
				.asSubclass(Annotation.class));
	}

	public static void main(String[] args) {
		Favorites f = new Favorites();
		f.putFavorite(String.class, "java");
		f.putFavorite(Integer.class, 0xabcde);
		f.putFavorite(Class.class, Favorites.class);
		String favoriteString = f.getFavorite(String.class);
		int favoriteInteger = f.getFavorite(Integer.class);
		Class<?> favoriteClass = f.getFavorite(Class.class);
		System.out.printf("%s %x %s%n", favoriteString, favoriteInteger,
				favoriteClass.getName());
	}
}
