package com.optimize.chapter2.duplicate;

public class DecoratorMain {

	public static void main(String[] args) {
		IPacketCreator pc = new PacketHTTPHeaderCreator(
				new PacketHTMLHeaderCreator(new PacketBodyCreator()));
		System.out.println(pc.handleContent());
	}
}
