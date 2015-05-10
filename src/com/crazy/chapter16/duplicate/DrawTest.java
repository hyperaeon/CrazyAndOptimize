package com.crazy.chapter16.duplicate;

import com.crazy.chapter16.TraditionalAccount;

public class DrawTest {

	public static void main(String[] args) {
		TraditionalAccount account = new TraditionalAccount("abcde", 0);
		new DrawThread("È¡Ç®Õß", account, 800).start();
		new DepositThread("´æÇ®Õß¼×", account, 800).start();
		new DepositThread("´æÇ®ÕßÒÒ", account, 800).start();
		new DepositThread("´æÇ®Õß±û", account, 800).start(); 
		
	}
}
