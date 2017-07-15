package com.jdk8;

public interface DefaultFunctionInterface {

	default String defaultFunction() {
		return "default function";
	}
	
	static String staticFunction() {
		return "static function";
	}
}
