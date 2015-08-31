package com.crazy.chapter17.duplicate.halfClose;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 30000);
		PrintStream ps = new PrintStream(socket.getOutputStream());
		Scanner scanner = new Scanner(System.in);
		String line = scanner.next();
		ps.println(scanner.next());
		BufferedReader br = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		System.out.println("From server: " + br.readLine());
		scanner.close();
		br.close();
		socket.close();
	}
}
