package com.crazy.chapter17.duplicate;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(80);
		while (true) {
			Socket s = ss.accept();
			PrintStream ps = new PrintStream(s.getOutputStream());
			ps.print("你好，您收到了服务器的新年祝福！");
			ps.close();
			s.close();
		}
	}
}
