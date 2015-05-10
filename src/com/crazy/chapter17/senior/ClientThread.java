package com.crazy.chapter17.senior;

import java.io.BufferedReader;
import java.io.IOException;

public class ClientThread extends Thread {

	BufferedReader br = null;

	public ClientThread(BufferedReader br) {
		this.br = br;
	}

	public void run() {
		try {
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
