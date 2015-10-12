package com.test;

import java.util.Map;

public class ParamTest {

	public static boolean test(Map<String, Integer> param) {
		return Math.abs(param.get("a")) > param.get("b")
				&& param.get("a") < Math.cos(param.get("b"))
				&& (param.get("a") + param.get("b") + param.get("c") * 2) > param
						.get("d");
	}
}
