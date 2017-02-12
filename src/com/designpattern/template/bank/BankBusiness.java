package com.designpattern.template.bank;

public abstract class BankBusiness {

	public int num;
	
	public BankBusiness(int num) {
		this.num = num;
	}
	
	protected void queue() {
		System.out.println(num + "号进入排队");
	}
	
	
	protected void judge() {
		System.out.println(num + "号对业务员打分");
	}
	
	public final void doBusiness() {
		queue();
		business();
		judge();
	}
	
	abstract void business();
}
