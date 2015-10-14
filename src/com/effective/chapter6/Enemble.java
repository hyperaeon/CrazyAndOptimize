package com.effective.chapter6;

public enum Enemble {

	SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5), SEXTET(6), SEPTET(7), OCTET(
			8), NONET(9), DECTET(10);

	private final int numberOfMusicians;

	Enemble(int size) {
		this.numberOfMusicians = size;
	}

	public int numberOfMusicians() {
		return numberOfMusicians;
	}
}
