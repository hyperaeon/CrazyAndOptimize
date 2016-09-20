package com.test;

public class CommentConstImpl implements CommentConst {

	int ContentLimit = 2000;
	
	public CommentConstImpl() {
		
	}
	
	public static void main(String[] args) {
		CommentConstImpl imple = new CommentConstImpl();
		System.out.println(imple.ContentLimit);
	}
}
