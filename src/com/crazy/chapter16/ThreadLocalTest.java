package com.crazy.chapter16;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class Account{
	private ThreadLocal<String> name = new ThreadLocal<>();
	
	public Account(String a){
		this.name.set(a);
		System.out.println("---" + this.name.get());
	}

	public String getName() {
		return this.name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}
}

class MyTest extends Thread{
	private Account account;
	public MyTest(Account account,String name){
		super(name);
		this.account = account;
	}
	
	public void run(){
		for(int i = 0 ; i < 10;i ++){
			if(i == 6){
				account.setName(getName());
			}
			System.out.println(account.getName() + " i的值  " + i);
		}
	}
}
public class ThreadLocalTest {

	public static void main(String[] args){
		Account account = new Account("新的账户");
		new MyTest(account,"线程1").start();
		new MyTest(account,"线程2").start();
		ConcurrentHashMap<String, Object> con = new ConcurrentHashMap<>(17);
		con.put("a", 1);
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list);
		for(Iterator<Integer> it = list.iterator(); it.hasNext();){
			if(it.next() == 2){
				it.remove();
			}
		}
		System.out.println(list);
		Boolean bo = new Boolean("True");
	}
}
