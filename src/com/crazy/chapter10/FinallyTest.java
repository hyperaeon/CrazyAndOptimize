package com.crazy.chapter10;

import java.io.FileInputStream;
import java.io.IOException;

public class FinallyTest {

	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("ab.txt");
		} catch (IOException e) {
			System.out.println(e.getMessage());
//			return;
			System.exit(1);
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Ö´ÐÐfinally");
		}
	}
}
