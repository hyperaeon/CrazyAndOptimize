package com.crazy.chapter17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread implements Runnable {

	Socket s = null;
	BufferedReader br = null;

	public ServerThread(Socket s) throws IOException {
		this.s = s;
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	}

	@Override
	public void run() {
		try {
			String content = null;
			System.out.println("ServerThread: " + content);
			while ((content = readLineFromClient()) != null) {
				for (Socket s : MyServer.socketList) {
					System.out.println(content);
					PrintStream ps = new PrintStream(s.getOutputStream());
					ps.print(content);
				}
			}
		} catch (Exception e) {
			System.out.println("Excepton");
			e.printStackTrace();
		}
	}

	public String readLineFromClient() {
		try {
			System.out.println("readLineFromClient() :" + br.readLine());
			return br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
			MyServer.socketList.remove(s);
		}
		return null;
	}

}
