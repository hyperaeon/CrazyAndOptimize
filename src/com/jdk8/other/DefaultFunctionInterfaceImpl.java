package com.jdk8.other;

public class DefaultFunctionInterfaceImpl implements DefaultFunctionInterface {

	public String defaultFunction() {
		return "subcleass default function";
	}
	
	public static void main(String[] args) {
		DefaultFunctionInterfaceImpl impl = new DefaultFunctionInterfaceImpl();
		System.out.println(impl.defaultFunction());
//		System.out.println(staticFunction());
	}
}
