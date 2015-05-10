package com.crazy.chapter8;

import java.util.Stack;

/**
 * @author Oliver
 *
 */
public class VectorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		Stack v = new Stack<>();
		v.push("java1");
		v.push("java2");
		v.push("java3");
		System.out.println(v);
		System.out.println(v.peek());
		System.out.println(v);
		System.out.println(v.pop());
		System.out.println(v);
		
	}
}
