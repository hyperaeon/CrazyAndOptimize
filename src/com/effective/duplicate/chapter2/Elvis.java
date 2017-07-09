package com.effective.duplicate.chapter2;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Elvis implements Serializable {

	private static final long serialVersionUID = 2883491452892916576L;
	
	public static final Elvis INSTANCE = new Elvis();
	
	private Elvis() {}
	
	public static Elvis getInstance() {
		return INSTANCE;
	}
	
	public void leaveTheBuilding() {}
	
	private Object readResolve() {
		return INSTANCE;
	}
	
	public static void main(String[] args){
		Long l = 9L;
		System.out.println(String.valueOf(l));
		long lo = 9;
		System.out.println(String.valueOf(lo));
		Map<String, String> map = new HashMap<String, String>();
		map.keySet();
		map.entrySet();
	}
}
