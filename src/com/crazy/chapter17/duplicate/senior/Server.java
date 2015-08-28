package com.crazy.chapter17.duplicate.senior;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static final int SERVER_PORT = 30000;
	public static CrazyitMap<String, PrintStream> clients = new CrazyitMap<String, PrintStream>();

	public void init() {
		try (ServerSocket ss = new ServerSocket(SERVER_PORT);) {
			while (true) {
				Socket socket = ss.accept();
				new ServerThread(socket).start();
			}
		} catch (IOException ex) {
			System.out.println("服务器启动失败，是否端口" + SERVER_PORT + "已经被占用");
		}
	}

	public static void main(String[] args) {
		Server server = new Server();
		server.init();
	}
}
