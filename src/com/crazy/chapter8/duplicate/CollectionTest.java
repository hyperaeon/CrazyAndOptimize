package com.crazy.chapter8.duplicate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CollectionTest {

	public static void main(String[] args) {
		Collection<Object> c = new ArrayList<>();
		c.add("孙悟空");
		c.add(6);
		System.out.println("c集合的元素个数为：" + c.size());
		c.remove(6);
		System.out.println("c集合的元素个数为：" + c.size());
		
		System.out.println("c集合是否包含“孙悟空”：" + c.contains("孙悟空"));
		
		c.add("轻量级Jave EE企业应用实战");
		System.out.println("c集合的元素：" + c);
		
		Collection<String> books = new HashSet<>();
		books.add("轻量级Jave EE企业应用实战");
		books.add("疯狂java讲义");
		System.out.println("c机会是否完全包含books集合" + c.containsAll(books));
		
		c.removeAll(books);
		System.out.println("c集合的元素：" + c);
		
		c.clear();
		System.out.println("c集合的元素：" + c);
		books.retainAll(c);
		System.out.println("books集合的元素：" + books);
	}
}
