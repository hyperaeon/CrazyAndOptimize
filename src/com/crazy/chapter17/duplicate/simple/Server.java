package com.crazy.chapter17.duplicate.simple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(30000);
		Socket socket = server.accept();
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		System.out.println("Message received from client: " + br.readLine());
		br.close();
		server.close();
	}
}
