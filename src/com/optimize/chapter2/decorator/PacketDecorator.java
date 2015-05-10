package com.optimize.chapter2.decorator;

public abstract class PacketDecorator implements IPacketCreator {

	IPacketCreator component;
	
	public PacketDecorator(IPacketCreator component) {
		this.component = component;
	}

}
