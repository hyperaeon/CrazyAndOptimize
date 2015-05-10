package com.crazy.chapter9;

import java.util.ArrayList;
import java.util.List;

public class ListErr {

	public static void main(String[] args){
		List list = new ArrayList<>();
		list.add("java1");
		list.add("java2");
		list.add(1);
		for(int i = 0;i < list.size();i ++){
			String str = (String)list.get(i);
		}
	}
	
}
