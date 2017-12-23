package com.natives;

import java.io.File;

public class NativeHello {

	public native void hello();
	
	static {
		System.loadLibrary("hello");
	}
	
	static
	{
		System.load("D:" + File.separator + "Hello.dll");
	}
	
	public static void main(String[] args) {
		NativeHello hello = new NativeHello();
		hello.hello();
	}
}
