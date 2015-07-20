package com.designpattern.prototype;

import java.io.IOException;

public class DeepCloneTest {

	public static void main(String[] args) throws ClassNotFoundException, IOException, CloneNotSupportedException {
		PlainObject po = new PlainObject("liyong", "123");
		DeepClone dc = new DeepClone("deepClone", po);
		System.out.println("-----Before clone");
		System.out.println("deepClone.deepName: " + dc.getDeepName());
		System.out.println("deepClone.plainObject.name: " + dc.getObj().getName());
		System.out.println("deepClone.plainObject.id: " + dc.getObj().getId());
//		DeepClone dc2 = (DeepClone) dc.deepClone();
		DeepClone dc2 = (DeepClone) dc.clone();
		dc2.setDeepName("deepClone2");
		dc2.getObj().setId("456");
		dc2.getObj().setName("yongli");
		System.out.println("-----After clone");
		System.out.println("deepClone.deepName: " + dc.getDeepName());
		System.out.println("deepClone.plainObject.name: " + dc.getObj().getName());
		System.out.println("deepClone.plainObject.id: " + dc.getObj().getId());
		
	}
}
