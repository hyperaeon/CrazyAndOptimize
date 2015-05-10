package com.crazy.chapter17;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(30000);
		while (true) {
			Socket socket = server.accept();
			PrintStream stream = new PrintStream(socket.getOutputStream());
			stream.print("您好！服务器收到了您的消息~！");
			stream.close();
			socket.close();
		}
	}
}
