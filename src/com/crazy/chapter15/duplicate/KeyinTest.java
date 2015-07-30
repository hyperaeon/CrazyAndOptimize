package com.crazy.chapter15.duplicate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyinTest {

	public static void main(String[] args) {
		try (InputStreamReader reader = new InputStreamReader(System.in);
				BufferedReader buff = new BufferedReader(reader)) {
			String buf = null;
			while ((buf = buff.readLine()) != null) {
				if ("exit".equals(buf)) {
					System.exit(1);
				}
				System.out.println("The content is " + buf);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
