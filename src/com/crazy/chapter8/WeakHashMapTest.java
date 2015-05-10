package com.crazy.chapter8;

import java.util.WeakHashMap;

public class WeakHashMapTest {

	public static void main(String[] args){
		WeakHashMap whm = new WeakHashMap<>();
		whm.put(new String("语文"), new String("良好"));
		whm.put(new String("数学"), new String("良好"));
		whm.put(new String("英语"), new String("及格"));
		whm.put("java", new String("中等"));
		String physic = new String("体育");
		whm.put(physic, new String("优秀"));
		System.out.println(whm);
		System.gc();
		System.runFinalization();
		System.out.println(whm);
		
	}
	
}
