package com.designpattern.interpreter.duplicate;

public class InterpreterTest {

	public static void main(String[] args) {
		int result = new Minus().interpret(new Context(new Plus()
				.interpret(new Context(9, 8)), 2));
		System.out.println(result);
	}
}
