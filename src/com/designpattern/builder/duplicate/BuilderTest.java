package com.designpattern.builder.duplicate;

public class BuilderTest {

	public static void main(String[] args) {
		Builder builder = new Builder();
		builder.produceEmailSender(10);
		builder.produceSmsSender(10);
	}
}
