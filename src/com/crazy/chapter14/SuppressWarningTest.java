package com.crazy.chapter14;

import java.util.ArrayList;
import java.util.List;
@SuppressWarnings(value="unchecked")
public class SuppressWarningTest {

	public static void main(String[] args){
		List myList = new ArrayList<Integer>();
		myList.add(20);
		List<String> list = myList;
		System.out.println(list.get(0));
	}
}
