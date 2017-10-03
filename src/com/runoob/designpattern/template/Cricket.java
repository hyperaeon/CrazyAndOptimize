package com.runoob.designpattern.template;

public class Cricket extends Game {

	@Override
	void initialize() {
		System.out.println("Cricket initialized!");
	}

	@Override
	void startPlay() {
		System.out.println("Cricket startPlay!");
	}

	@Override
	void endPlay() {
		System.out.println("Cricket endPlay!");
	}

}
