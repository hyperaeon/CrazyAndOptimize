package com.effective.chapter5;

import java.util.HashSet;
import java.util.Set;

public class IdentityFunction<T>{

	private static UnaryFunction<Object> IDENTITY_FUNCTION = new UnaryFunction<Object>() {
		public Object apply(Object arg) {
			return arg;
		}
	};
	
	@SuppressWarnings("unchecked")
	public static <T> UnaryFunction<T> identityFunction() {
		return (UnaryFunction<T>)IDENTITY_FUNCTION;
	}
	
	public static void test() {
		Set<Integer> integers = new HashSet<>();
		Set<Double> doubles = new HashSet<>();
		//Sepecial
		Set<Number> numbers = IdentityFunction.<Number>union(integers, doubles);
	}
	
	public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
		Set<E> result = new HashSet<E>(s1);
		result.addAll(s2);
		return result;
	}
	
	public static void main(String[] args) {
		String[] strings = {"June","Eaeo","Loe"};
		UnaryFunction<String> sameString = identityFunction();
		for (String s : strings) {
			System.out.println(sameString.apply(s));
		}
		test();
	}

}
