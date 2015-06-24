package com.crazy.chapter8.duplicate.set;

import java.util.Collections;
import java.util.TreeSet;

class RR implements Comparable<RR> {
	int count;

	public RR(int count) {
		this.count = count;
	}

	@Override
	public int compareTo(RR o) {
		return count > o.count ? 1 : count < o.count ? -1 : 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RR [count=" + count + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RR other = (RR) obj;
		if (count != other.count)
			return false;
		return true;
	}

}

public class TreeSetTest3 {

	public static void main(String[] args) {
		TreeSet<RR> set = new TreeSet<>();
		set.add(new RR(5));
		set.add(new RR(-3));
		set.add(new RR(9));
		set.add(new RR(-2));
		System.out.println(set);
		RR first = set.first();
		first.count  = 20;
		RR last = set.last();
		last.count = -2;
		System.out.println(set);
		System.out.println(set.remove(new RR(-2)));
		System.out.println(set);
		System.out.println(set.remove(new RR(5)));
		System.out.println(set);
		System.out.println(set.remove(new RR(-2)));
		System.out.println(set);
		System.out.println(set.remove(new RR(-2)));
		System.out.println(set);
	}
}

