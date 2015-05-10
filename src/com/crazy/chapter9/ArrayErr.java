package com.crazy.chapter9;

public class ArrayErr {

	public static void main(String[] args){
		Integer[] ia = new Integer[5];
		Number[] numb = ia;
		ia[1] = 3;
		System.out.println(numb[0]);
	}
}
