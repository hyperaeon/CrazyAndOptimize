package com.optimize.chapter2.duplicate;

public abstract class PacketDecorator implements IPacketCreator {

	IPacketCreator component;
	
	public PacketDecorator(IPacketCreator c) {
		this.component = c;
	}
	

}
