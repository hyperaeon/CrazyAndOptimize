package com.crazy.chapter17.duplicate.halfClose;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(30000);
		Socket s = ss.accept();
		PrintStream ps = new PrintStream(s.getOutputStream());
		ps.println("first line");
		ps.println("second line");
		s.shutdownOutput();
		System.out.println(s.isClosed());
		Scanner scanner = new Scanner(s.getInputStream());
		while (scanner.hasNext()) {
			System.out.println(scanner.next());
		}
		scanner.close();
		s.close();
		ss.close();

	}
}
