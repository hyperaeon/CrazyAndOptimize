package com.designpattern.factory.simpleFactory;

public class SendFactory {

	public Sender produce(String type) {
		if ("mail".equals(type)) {
			return new MailSender();
		} else if("sms".equals(type)) {
			return new SmsSender();
		} else {
			System.out.println("类型不正确");
			return null;
		}
	}
}
