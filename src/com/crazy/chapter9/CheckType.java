package com.crazy.chapter9;

import java.util.ArrayList;
import java.util.List;

class StrList{
	private List strList = new ArrayList<>();
	public boolean add(String ele){
		return strList.add(ele);
	}
	public String get(int index){
		return (String)strList.get(index);
	}
	public int size(){
		return strList.size();
	}
}
public class CheckType {

	public static void main(String[] args){
		StrList strList = new StrList();
		strList.add("java1");
		
	}
}
