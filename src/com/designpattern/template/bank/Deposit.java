package com.designpattern.template.bank;

public class Deposit extends BankBusiness {

	public Deposit(int num) {
		super(num);
	}
	
	@Override
	public void business() {
		System.out.println(super.num + "号客户进行存款操作");
	}

}
