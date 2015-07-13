package com.natives;

public class NativeHello {

	public native void hello();
	
	static {
		System.loadLibrary("hello");
	}
	
	public static void main(String[] args) {
		NativeHello hello = new NativeHello();
		hello.hello();
	}
}
