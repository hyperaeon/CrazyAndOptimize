package com.crazy.chapter8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CollectionTest {

	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("�����");
		c.add(6);
		System.out.println("c���ϵ�Ԫ�ظ���Ϊ��" + c.size());
		
		c.remove(6);
		System.out.println("c���ϵ�Ԫ�ظ���Ϊ��" + c.size());
		
		System.out.println("c�����Ƿ����\"�����\"�ַ���" + c.contains("�����"));
		
		c.add("������Java");
		System.out.println("c���ϵ�Ԫ�أ�" + c);
		
		Collection books = new HashSet<>();
		books.add("������Java");
		books.add("���java����");
		System.out.println("c�����Ƿ���ȫ����books���ϣ�" + c.containsAll(books));
		
		c.removeAll(books);
		c.clear();
		System.out.println("c���ϵ�Ԫ�أ�" + c);
		books.retainAll(c);
		System.out.println("books���ϵ�Ԫ�أ�" + books);
	}

}
