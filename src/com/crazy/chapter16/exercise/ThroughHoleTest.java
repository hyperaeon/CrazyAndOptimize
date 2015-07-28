package com.crazy.chapter16.exercise;

import java.util.Random;

public class ThroughHoleTest {

	public static void main(String[] args) {
		Hole hole = new Hole("�춥ɽ", Long.valueOf(100000));
		String[] personNames = { "asdf", "sdf", "fg", "er", "xcv", "sf", "reg",
				"dfg", "eer", "egr" };
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			// new Thread(new ThroughHole(hole,personNames[i])).start();
			System.out.println(random.nextInt(10));
		}
	}
}
