package com.crazy.chapter8;

import java.util.TreeSet;

class Ro implements Comparable{
	int count;
	public Ro(int count){
		this.count = count;
	}
	public String toString(){
		return "Ro[count:" + count + "]";
	}
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj != null && obj.getClass() == Ro.class){
			Ro Ro = (Ro)obj;
			if(Ro.count == this.count)
				return true;
		}
		return false;
	}
	public int compareTo(Object obj){
		Ro Ro = (Ro)obj;
		return count > Ro.count ? 1 : count < Ro.count ? -1 : 0;
	}
	
}
public class TreeSetTest3 {

	public static void main(String[] args){
		TreeSet<Ro> ts = new TreeSet<>();
		ts.add(new Ro(5));
		ts.add(new Ro(-3));
		ts.add(new Ro(9));
		ts.add(new Ro(-2));
		System.out.println(ts);
		Ro first = ts.first();
		first.count = 20;
		Ro last = ts.last();
		last.count = -2;
		System.out.println(ts);
		
		System.out.println(ts.remove(new Ro(-2)));
		System.out.println(ts);
		System.out.println(ts.remove(new Ro(5)));
		System.out.println(ts);
		System.out.println(ts.remove(new Ro(-2)));
		System.out.println(ts);
		System.out.println(ts.remove(new Ro(-2)));
		System.out.println(ts);
	}
}
