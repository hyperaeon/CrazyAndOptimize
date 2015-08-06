package com.crazy.chapter7;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloArg {

	public static void main(String[] args) {
		Locale currentLocale = null;
		if (args.length == 2) {
			currentLocale = new Locale(args[0], args[1]);
		} else {
			currentLocale = Locale.getDefault(Locale.Category.FORMAT);
		}
		ResourceBundle bundle = ResourceBundle.getBundle("myMess",
				currentLocale);
		String msg = bundle.getString("msg");
		System.out.println(MessageFormat.format(msg, "liyong", new Date()));
	}
}
