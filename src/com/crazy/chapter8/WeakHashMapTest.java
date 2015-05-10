package com.crazy.chapter8;

import java.util.WeakHashMap;

public class WeakHashMapTest {

	public static void main(String[] args){
		WeakHashMap whm = new WeakHashMap<>();
		whm.put(new String("����"), new String("����"));
		whm.put(new String("��ѧ"), new String("����"));
		whm.put(new String("Ӣ��"), new String("����"));
		whm.put("java", new String("�е�"));
		String physic = new String("����");
		whm.put(physic, new String("����"));
		System.out.println(whm);
		System.gc();
		System.runFinalization();
		System.out.println(whm);
		
	}
	
}
