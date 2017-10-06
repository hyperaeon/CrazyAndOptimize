package com.runoob.designpattern.interceptfilter;

public class DebugFilter implements Filter {

	@Override
	public void execute(String request) {
		System.out.println("Reqeust log: " + request) ;
	}

}
