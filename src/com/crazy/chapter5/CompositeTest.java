package com.crazy.chapter5;

public class CompositeTest {

	public static void main(String[] args) {
		
		Animal a = new Animal();
		Bird b = new Bird(a);
		b.beat();
		b.breath();
	}

}
