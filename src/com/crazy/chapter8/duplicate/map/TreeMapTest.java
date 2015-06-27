package com.crazy.chapter8.duplicate.map;

import java.util.TreeMap;

class R implements Comparable<R> {
	int count;

	public R(int count) {
		this.count = count;
	}

	public String toString() {
		return "R[count:" + count + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj != null && obj.getClass() == R.class) {
			R r = (R) obj;
			return r.count == this.count;
		}
		return false;
	}

	@Override
	public int compareTo(R o) {
		return count > o.count ? 1 : count < o.count ? -1 : 0;
	}
}

public class TreeMapTest {

	public static void main(String[] args) {
		TreeMap<R, String> tm = new TreeMap<R, String>();
		tm.put(new R(3), "java1");
		tm.put(new R(-5), "java2");
		tm.put(new R(9), "java3");
		System.out.println(tm);

		System.out.println(tm.firstEntry());
		System.out.println(tm.lastKey());
		System.out.println(tm.higherKey(new R(2)));
		System.out.println(tm.lowerEntry(new R(2)));
		System.out.println(tm.subMap(new R(-5), new R(4)));
	}
}
