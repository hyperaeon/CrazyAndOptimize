package com.crazy.chapter7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KeyboardInTest {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println("用户键盘输入的是： " + line);
		}
		
	}
}
