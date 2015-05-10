package com.crazy.chapter8;

import java.util.TreeMap;

class Rt implements Comparable{
	int count;
	public Rt(int count){
		this.count  = count;
	}
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}
		if(obj != null && obj.getClass() == Rt.class){
			Rt Rt = (Rt)obj;
			return Rt.count == this.count;
		}
		return false;
	}
	public int compareTo(Object obj){
		Rt Rt = (Rt)obj;
		return count > Rt.count ? 1
				: count < Rt.count ? -1 : 0;
	}
	public String toString(){
		return "R[count:" + count + "]";
	}
}
public class TreeMapTest {

	public static void main(String[] args){
		TreeMap tm = new TreeMap<>();
		tm.put(new Rt(3), "java1");
		tm.put(new Rt(-5), "java2");
		tm.put(new Rt(9), "java3");
		System.out.println(tm);
		System.out.println(tm.firstEntry());
		System.out.println(tm.lastKey());
		System.out.println(tm.higherKey(new Rt(2)));
		System.out.println(tm.lowerEntry(new Rt(2)));
		System.out.println(tm.subMap(new Rt(-1),new Rt(4)));
	}
}
