package com.crazy.chapter8.duplicate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CollectionTest {

	public static void main(String[] args) {
		Collection<Object> c = new ArrayList<>();
		c.add("�����");
		c.add(6);
		System.out.println("c���ϵ�Ԫ�ظ���Ϊ��" + c.size());
		c.remove(6);
		System.out.println("c���ϵ�Ԫ�ظ���Ϊ��" + c.size());
		
		System.out.println("c�����Ƿ����������ա���" + c.contains("�����"));
		
		c.add("������Jave EE��ҵӦ��ʵս");
		System.out.println("c���ϵ�Ԫ�أ�" + c);
		
		Collection<String> books = new HashSet<>();
		books.add("������Jave EE��ҵӦ��ʵս");
		books.add("���java����");
		System.out.println("c�����Ƿ���ȫ����books����" + c.containsAll(books));
		
		c.removeAll(books);
		System.out.println("c���ϵ�Ԫ�أ�" + c);
		
		c.clear();
		System.out.println("c���ϵ�Ԫ�أ�" + c);
		books.retainAll(c);
		System.out.println("books���ϵ�Ԫ�أ�" + books);
	}
}
