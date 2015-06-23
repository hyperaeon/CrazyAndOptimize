package com.crazy.chapter7;

import java.util.Scanner;

public class ScannerKeyBordTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter("\n");
		while (scanner.hasNext()) {
			System.out.println(scanner.next());
		}
	}
}
