package com.jdk8.other;

public interface DefaultFunctionInterface {

	default String defaultFunction() {
		return "default function";
	}
	
	static String staticFunction() {
		return "static function";
	}
}
