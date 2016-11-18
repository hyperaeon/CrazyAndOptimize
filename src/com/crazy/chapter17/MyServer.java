package com.crazy.chapter17;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyServer {

	public static List<Socket> socketList = new ArrayList<Socket>();

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(30000);
		while (true) {
			Socket socket = server.accept();
			System.out.println("MyServer: " + socket.toString());
			new Thread(new ServerThread(socket)).start();
			socketList.add(socket);
		}
	}
}
