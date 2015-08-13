package com.crazy.chapter17.duplicate.simple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("127.0.0.1", 30000);
		PrintStream ps = new PrintStream(socket.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		ps.print(line);
		br.close();
		socket.close();
	}
	
}
