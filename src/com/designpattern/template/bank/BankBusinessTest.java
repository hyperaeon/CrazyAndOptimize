package com.designpattern.template.bank;

public class BankBusinessTest {

	public static void main(String[] args) {
		BankBusiness bank = new Deposit(1);
		bank.doBusiness();
		bank = new Draw(2);
		bank.doBusiness();
	}
}
