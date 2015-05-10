package com.crazy.chapter17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class MyClient {

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("127.0.0.1", 30000);
		new Thread(new ClientThread(socket)).start();
		System.out.println("MyClient localPort:" + socket.getLocalPort());
		PrintStream ps = new PrintStream(socket.getOutputStream());
		String line = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		
		while ((line = reader.readLine()) != null) {
			System.out.println("line:" + line);
			ps.print(line);
			System.out.println("After MyClient line:" + line);
		}
		// if ((line = reader.readLine()) != null) {
		// ps.print(line);
		// }
	}
}
