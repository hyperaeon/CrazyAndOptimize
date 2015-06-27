package com.interview.chapter9;
class Base {}

class Agg extends Base {
	public String getFields() {
		return "Agg";
	}
}

public class Avf {

	public static void main(String[] args) {
		Base a = new Agg();
		System.out.println(((Agg)a).getFields());
	}
}
