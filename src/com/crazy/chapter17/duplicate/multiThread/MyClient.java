package com.crazy.chapter17.duplicate.multiThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import com.crazy.chapter17.ClientThread;

public class MyClient {

	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1", 30000);
		new Thread(new ClientThread(socket)).start();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String line = null;
		PrintStream ps = new PrintStream(socket.getOutputStream());
		while ((line = reader.readLine()) != null) {
			ps.print(line);
		}
	}
}
