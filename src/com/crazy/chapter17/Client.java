package com.crazy.chapter17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("127.0.0.1", 30000);
		socket.setSoTimeout(10000);
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		String line = reader.readLine();
		System.out.println("来自服务器的消息:" + line);
		PrintStream ps = new PrintStream(socket.getOutputStream());
		ps.print("服务器你好！");
		reader.close();
		socket.close();
	}
}
