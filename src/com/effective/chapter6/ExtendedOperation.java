package com.effective.chapter6;

import java.util.Arrays;
import java.util.Collection;

public enum ExtendedOperation implements Opera {

	EXP("^") {
		public double apply(double x, double y) {
			return Math.pow(x, y);
		}
	},
	REMAINDER("%") {
		public double apply(double x, double y) {
			return x % y;
		}
	};

	private final String symbol;

	ExtendedOperation(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}

	public static void main(String[] args) {
		double x = 3.2;
		double y = 3.3;
		test(ExtendedOperation.class, x, y);
		test(Arrays.asList(ExtendedOperation.values()), x, y);
	}

	public static <T extends Enum<T> & Opera> void test(Class<T> type,
			double x, double y) {
		for (Opera o : type.getEnumConstants()) {
			System.out.printf("%f %s %f = %f%n", x, o, y, o.apply(x, y));
		}
	}

	public static void test(Collection<? extends Opera> opSet, double x,
			double y) {
		for (Opera o : opSet) {
			System.out.printf("%f %s %f = %f%n", x, o, y, o.apply(x, y));
		}
	}
}
