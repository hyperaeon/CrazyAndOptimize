package com.crazy.chapter6.duplicate;

class CacheImmutale {
	private static int MAX_SIZE = 10;
	private static CacheImmutale[] cache = new CacheImmutale[MAX_SIZE];
	private static int pos;
	private final String name;

	private CacheImmutale(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static CacheImmutale valueOf(String name) {
		for (int i = 0; i < MAX_SIZE; i++) {
			if (cache[i] != null && cache[i].getName().equals(name)) {
				return cache[i];
			}
		}
		if (pos == MAX_SIZE) {
			cache[0] = new CacheImmutale(name);
			pos = 1;
		} else {
			cache[pos++] = new CacheImmutale(name);
		}
		return cache[pos - 1];
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj != null && obj.getClass() == CacheImmutale.class) {
			CacheImmutale other = (CacheImmutale) obj;
			return other.getName().equals(name);
		}
		return false;
	}

	public int hashCode() {
		return name.hashCode();
	}
}

public class CacheImmutaleTest {

	public static void main(String[] args) {
		CacheImmutale c1 = CacheImmutale.valueOf("hello");
		CacheImmutale c2 = CacheImmutale.valueOf("hello");
		System.out.println(c1 == c2);Integer.valueOf(2);
	}
}
