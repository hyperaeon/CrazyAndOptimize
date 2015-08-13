package com.crazy.chapter17.duplicate.multiThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread implements Runnable {

	private Socket socket;
	private BufferedReader reader;

	public ClientThread(Socket socket) throws IOException {
		this.socket = socket;
		this.reader = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
	}

	@Override
	public void run() {
		try {
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println("Message from server: " + line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
