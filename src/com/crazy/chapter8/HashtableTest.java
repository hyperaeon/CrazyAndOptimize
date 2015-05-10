package com.crazy.chapter8;

import java.util.Hashtable;

class E{
	int count;
	public E(int count){
		this.count = count;
	}
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}
		if(obj != null && obj.getClass() == E.class){
			E e = (E)obj;
			return this.count == e.count;
		}
		return false;
	}
	public int hashCode()
	{
		return this.count;
	}
}
class F{
	public boolean equals(Object obj){
		return true;
	}
}
public class HashtableTest {

	public static void main(String[] arg){
		Hashtable ht = new Hashtable<>();
		ht.put(new E(9000), "java1");
		ht.put(new E(3000), "java2");
		ht.put(new E(6000), new F());
		System.out.println(ht);
		System.out.println(ht.containsValue("javaX"));
		System.out.println(ht.containsKey(new E(6000)));
		ht.remove(new E(6000));
		for(Object key : ht.keySet()){
			System.out.print(key + "--->");
			System.out.print(ht.get(key) + "\n");
		}
		
	}
}
