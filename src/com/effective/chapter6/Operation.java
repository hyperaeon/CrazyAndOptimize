package com.effective.chapter6;

import java.util.HashMap;
import java.util.Map;

public enum Operation {

	PLUS("+") {
		double op(double x, double y) {
			return x + y;
		}
	},
	MINUS("-") {
		double op(double x, double y) {
			return x - y;
		}
	},
	MULTIPLY("*") {
		double op(double x, double y) {
			return x * y;
		}
	},
	DIVIDE("/") {
		double op(double x, double y) {
			return x / y;
		}
	};

	abstract double op(double x, double y);

	private final String symbol;

	Operation(String symbol) {
		this.symbol = symbol;
	}

	// double apply(double x, double y) {
	// switch (this) {
	// case PLUS("+"):
	// return x + y;
	// case MINUS("-"):
	// return x - y;
	// case MULTIPLY("*"):
	// return x * y;
	// case DIVIDE("/"):
	// return x / y;
	// }
	// throw new AssertionError("Unknown op: " + this);
	// }

	public String toString() {
		return symbol;
	}

	private static final Map<String, Operation> stringToEnum = new HashMap<String, Operation>();

	static {
		for (Operation op : values()) {
			stringToEnum.put(op.toString(), op);
		}
	}

	public static Operation fromString(String symbol) {
		return stringToEnum.get(symbol);
	}
}
