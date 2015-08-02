package com.crazy.chapter15.duplicate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromProcess {

	public static void main(String[] args) throws IOException {
		Process p = Runtime.getRuntime().exec("javac");
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				p.getErrorStream()))) {
			String buff = null;
			while ((buff = br.readLine()) != null) {
				System.out.println(buff);
			}
		}
	}
}
