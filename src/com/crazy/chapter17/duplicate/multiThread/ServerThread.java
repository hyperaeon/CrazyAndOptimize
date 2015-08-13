package com.crazy.chapter17.duplicate.multiThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread implements Runnable {

	private Socket socket;
	private BufferedReader reader;

	public ServerThread(Socket socket) throws IOException {
		this.socket = socket;
		this.reader = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
	}

	@Override
	public void run() {
		String content;
		try {
			while ((content = reader.readLine()) != null) {
				for (Socket s : MyServer.socketList) {
					PrintStream ps = new PrintStream(s.getOutputStream());
					ps.print(content);
					System.out.println("Content from client: " + content);
				}
			}
		} catch (IOException e) {
			MyServer.socketList.remove(socket);
			e.printStackTrace();
		}
	}

}
