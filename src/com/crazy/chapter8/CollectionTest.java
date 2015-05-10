package com.crazy.chapter8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CollectionTest {

	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("孙悟空");
		c.add(6);
		System.out.println("c集合的元素个数为：" + c.size());
		
		c.remove(6);
		System.out.println("c集合的元素个数为：" + c.size());
		
		System.out.println("c集合是否包含\"孙悟空\"字符串" + c.contains("孙悟空"));
		
		c.add("轻量级Java");
		System.out.println("c集合的元素：" + c);
		
		Collection books = new HashSet<>();
		books.add("轻量级Java");
		books.add("疯狂java讲义");
		System.out.println("c集合是否完全包含books集合？" + c.containsAll(books));
		
		c.removeAll(books);
		c.clear();
		System.out.println("c集合的元素：" + c);
		books.retainAll(c);
		System.out.println("books集合的元素：" + books);
	}

}
