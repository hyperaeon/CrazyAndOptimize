package com.runoob.designpattern.template;

public class Football extends Game {

	@Override
	void initialize() {
		System.out.println("Football initialized!");
	}

	@Override
	void startPlay() {
		System.out.println("Football startPlay!");
	}

	@Override
	void endPlay() {
		System.out.println("Football endPlay!");
	}

}
