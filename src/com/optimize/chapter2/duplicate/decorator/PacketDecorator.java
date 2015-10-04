package com.optimize.chapter2.duplicate.decorator;

public abstract class PacketDecorator implements IPacketCreator {

	IPacketCreator component;
	
	public PacketDecorator(IPacketCreator c) {
		component = c;
	}
}
