package com.designpattern.builder;

public class BuilderTest {

	public static void main(String[] args) {
		Builder builder = new Builder();
		builder.produceMailSender(10);
	}
}
