package com.effective.chapter7;

class Wine {
	String name() {
		return "wine";
	}
}

class SparklingWine extends Wine {
	String name() {
		return "SparklingWine";
	}
}

class Champagne extends Wine {
	String name() {
		return "Champagne";
	}
}

public class Overriding {

	public static void main(String[] args) {
		Wine[] wines = { new Wine(), new SparklingWine(), new Champagne() };
		for (Wine w : wines) {
			System.out.println(w.name());
		}
	}
}
