package com.crazy.chapter7;

import java.io.File;
import java.util.Scanner;

import com.crazy.Constants;

public class ScannerFileTest {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File(Constants.basicPath + "chapter7\\ScannerFileTest.java"));
		System.out.println("ScannerFileTest.java ÄÚÈİÈçÏÂ£º");
		while (sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
	}
}
