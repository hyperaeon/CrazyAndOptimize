package com.crazy.chapter5;

import java.util.ArrayList;
import java.util.List;

public class GetListTest {

	private List<String> list = new ArrayList<>();

	private String str = "abc";

	public static void main(String[] args) {
		GetListTest test = new GetListTest();
		test.getList();
		List<String> lt = new ArrayList<>();
		lt = new ArrayList<>();
		if (test.getList() == null) {
			test.setList(new ArrayList<String>());
		}
		test.getStr();
		test.run();
		new GetListTest().getList();
	}

	public void jump() {
		System.out.println("Jump");
	}
	
	public void run() {
		jump();
		System.out.println("run");
	}
	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	/**
	 * @return the str
	 */
	public String getStr() {
		return str;
	}

	/**
	 * @param str
	 *            the str to set
	 */
	public void setStr(String str) {
		this.str = str;
	}

}
