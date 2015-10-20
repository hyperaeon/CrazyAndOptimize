package com.effective.chapter7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionClassifier {

	public static String classify(Set<?> s) {
		return "set";
	}

	public static String classify(List<?> l) {
		return "list";
	}

	public static String classify(Collection<?> c) {
		return "collection";
	}

	public static void main(String[] args) {
		Collection<?>[] collections = { new HashSet<String>(),
				new ArrayList<String>(), new HashMap<String, String>().values() };
		for (Collection<?> c : collections) {
			System.out.println(classify(c));
		}
	}
}
