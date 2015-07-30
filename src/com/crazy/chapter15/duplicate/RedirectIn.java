package com.crazy.chapter15.duplicate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class RedirectIn {

	public static void main(String[] args) {
		try (FileInputStream fis = new FileInputStream(Constants.basicPath
				+ "RedirectIn.java")) {
			System.setIn(fis);
			Scanner sc = new Scanner(System.in);
			sc.useDelimiter("\n");
			while (sc.hasNext()) {
				System.out.println("键盘输入的内容：" + sc.next());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
