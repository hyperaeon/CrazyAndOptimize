package com.crazy.chapter14;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ErrorUtils {

	@SafeVarargs
	public static void faultyMethod(List<String>... listStrArray){
		List[] listArray = listStrArray;
		List<Integer> myList = new ArrayList<Integer>();
		myList.add(new Random().nextInt(100));
		listArray[0] = myList;
		String s = listStrArray[0].get(0);
				
	}
}
