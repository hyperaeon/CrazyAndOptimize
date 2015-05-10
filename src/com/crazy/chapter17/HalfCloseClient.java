package com.crazy.chapter17;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class HalfCloseClient {

	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1", 30000);
		PrintStream ps = new PrintStream(socket.getOutputStream());
		ps.println("Hello");
		ps.close();
		socket.close();
	}
}
