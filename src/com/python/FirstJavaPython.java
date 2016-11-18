package com.python;

import org.python.util.PythonInterpreter;

public class FirstJavaPython {

	public static void main(String[] args) {
		PythonInterpreter interpreter = new PythonInterpreter();
		interpreter.exec("days=('Mod','Tue','Web','Thu','Fri')");
		interpreter.exec("print(days[1])");
	}
}
