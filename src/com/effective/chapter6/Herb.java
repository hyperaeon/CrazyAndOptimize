package com.effective.chapter6;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Herb {

	public enum Type {
		ANNUAL, PERENNIAL, BIENNIAL
	}

	private final String name;
	private final Type type;

	Herb(String name, Type type) {
		this.name = name;
		this.type = type;
	}

	public String toString() {
		return name;
	}

	public static void main(String[] args) {
		Herb[] garden = { new Herb("一年生", Type.ANNUAL),
				new Herb("多年生", Type.PERENNIAL), new Herb("两年生", Type.BIENNIAL) };
		Set<Herb>[] herbsByType = (Set<Herb>[]) new Set[Herb.Type.values().length];
		for (int i = 0; i < herbsByType.length; i++) {
			herbsByType[i] = new HashSet<Herb>();
		}
		for (Herb h : garden) {
			herbsByType[h.type.ordinal()].add(h);
		}
		for (int i = 0; i < herbsByType.length; i++) {
			System.out
					.printf("%s: %s%n", Herb.Type.values()[i], herbsByType[i]);
		}
		
		test();
	}

	public static void test() {
		Herb[] garden = { new Herb("一年生", Type.ANNUAL),
				new Herb("多年生", Type.PERENNIAL), new Herb("两年生", Type.BIENNIAL) };
		Map<Herb.Type, Set<Herb>> herbs = new EnumMap<Herb.Type, Set<Herb>>(
				Herb.Type.class);
		for (Herb.Type t : Herb.Type.values()) {
			herbs.put(t, new HashSet<Herb>());
		}
		for (Herb h : garden) {
			herbs.get(h.type).add(h);
		}
		System.out.println(herbs);
	}
}
