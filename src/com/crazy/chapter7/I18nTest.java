package com.crazy.chapter7;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18nTest {

	public static void main(String[] args) {
		Locale myLocale = Locale.getDefault(Locale.Category.FORMAT);
		ResourceBundle bundle = ResourceBundle.getBundle("mess", myLocale);
		System.out.println(bundle.getString("hello"));
	}
}
