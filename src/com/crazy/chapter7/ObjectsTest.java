package com.crazy.chapter7;

import java.util.Objects;

public class ObjectsTest {

	static ObjectsTest obj;

	public static void main(String[] args) {

		System.out.println(Objects.hashCode(obj));
		System.out.println(Objects.toString(obj));
		System.out.println(Objects.requireNonNull(obj, "obj参数不能是null!"));
	}
}
