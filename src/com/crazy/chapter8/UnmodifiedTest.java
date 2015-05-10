package com.crazy.chapter8;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UnmodifiedTest {

	public static void main(String[] args){
		List unmodifiableList = Collections.emptyList();
		Set unmodifiableSet = Collections.singleton("java1");
		Map scores = new HashMap();
		scores.put("java1", 100);
		scores.put("java2", 70);
		Map unmodifiableMap = Collections.unmodifiableMap(scores);
		unmodifiableList.add("java3");
		unmodifiableSet.add("java4");
		unmodifiableMap.put("java5", 80);
	}
}
