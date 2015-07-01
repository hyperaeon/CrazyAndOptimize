package com.designpattern.factory.staticFactory;

import com.designpattern.factory.simpleFactory.MailSender;
import com.designpattern.factory.simpleFactory.Sender;
import com.designpattern.factory.simpleFactory.SmsSender;

public class SendFactory {

	public static Sender produceMail() {
		return new MailSender();
	}

	public static Sender produceSms() {
		return new SmsSender();
	}
}
