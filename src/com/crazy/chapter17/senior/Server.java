package com.crazy.chapter17.senior;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static final int SERVER_PORT = 30000;
	public static CrazyitMap<String, PrintStream> clients = new CrazyitMap<>();

	public void init() {
		try (ServerSocket ss = new ServerSocket(SERVER_PORT)) {
			while (true) {
				Socket socket = ss.accept();
				new ServerThread(socket).start();
			}
		} catch (IOException ex) {
			System.out.println("����������ʧ�ܣ��Ƿ�˿�" + SERVER_PORT + "�ѱ�ռ�ã�");
		}
	}

	public static void main(String[] args) {
		Server server = new Server();
		server.init();
	}
}
