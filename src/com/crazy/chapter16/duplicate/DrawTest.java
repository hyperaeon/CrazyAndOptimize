package com.crazy.chapter16.duplicate;

import com.crazy.chapter16.TraditionalAccount;

public class DrawTest {

	public static void main(String[] args) {
		TraditionalAccount account = new TraditionalAccount("abcde", 0);
		new DrawThread("ȡǮ��", account, 800).start();
		new DepositThread("��Ǯ�߼�", account, 800).start();
		new DepositThread("��Ǯ����", account, 800).start();
		new DepositThread("��Ǯ�߱�", account, 800).start(); 
		
	}
}
