/**
 * 
 */
package com.crazy.chapter17.duplicate.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author ly
 *
 */
public class UdpClient {

	private static final int PORT = 30000;

	private static final String DEST_IP = "127.0.0.1";

	private static final int DATA_LEN = 4096;

	byte[] inBuff = new byte[DATA_LEN];

	private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);

	private DatagramPacket outPacket;

	public void init() throws IOException {
		try (DatagramSocket socket = new DatagramSocket()) {
			outPacket = new DatagramPacket(new byte[0], 0, InetAddress.getByName(DEST_IP), PORT);
			Scanner scan = new Scanner(System.in);
			while (scan.hasNext()) {
				byte[] buff = scan.nextLine().getBytes();
				outPacket.setData(buff);
				socket.send(outPacket);
				socket.receive(inPacket);
				System.out.println(new String(inBuff, 0, inPacket.getLength()));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		new UdpClient().init();
	}
}
