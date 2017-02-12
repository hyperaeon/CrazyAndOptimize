package com.designpattern.template.bank;

public class Draw extends BankBusiness {
	
	public Draw(int num) {
		super(num);
	}

	@Override
	public void business() {
		System.out.println(super.num + "号客户进行取款操作");
	}

}
