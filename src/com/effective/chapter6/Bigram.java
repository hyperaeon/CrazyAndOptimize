package com.effective.chapter6;

import java.util.HashSet;
import java.util.Set;

public class Bigram {

	private char first;
	private char second;

	Bigram(char first, char second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Bigram)) {
			return false;
		}
		Bigram b = (Bigram) o;
		return b.first == first && b.second == second;
	}

	public int hashCode() {
		return 31 * first + second;
	}

	public static void main(String[] args) {
		Set<Bigram> bigSet = new HashSet<Bigram>();
		for (int i = 0; i < 10; i++) {
			for (char c = 'a'; c <= 'z'; c++) {
				bigSet.add(new Bigram(c, c));
			}
		}
		System.out.println(bigSet.size());
	}
}
