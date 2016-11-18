package com.crazy.chapter17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(30000);
		BufferedReader br = null;
		while (true) {
			Socket socket = server.accept();
			PrintStream stream = new PrintStream(socket.getOutputStream());
			stream.print("您好！服务器收到了您的消息~！");
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("来自客户端的消息：" + br.readLine());
			stream.close();
			socket.close();
		}
	}
}
