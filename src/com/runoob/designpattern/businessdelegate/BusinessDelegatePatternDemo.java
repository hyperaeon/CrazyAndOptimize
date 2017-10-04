package com.runoob.designpattern.businessdelegate;

public class BusinessDelegatePatternDemo {

	public static void main(String[] args) {
		BusinessDelegate businessDelegate = new BusinessDelegate();
		businessDelegate.setServiceTpe("EJB");
		
		Client client = new Client(businessDelegate);
		client.doTask();
		
		businessDelegate.setServiceTpe("JMS");
		client.doTask();
	}
}
