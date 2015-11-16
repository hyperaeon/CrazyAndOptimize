package com.effective.chapter11;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Foo extends AbstractFoo {

	private static final long serialVersionUID = 1L;

	private void readObject(ObjectInputStream ois) throws IOException,
			ClassNotFoundException {
		ois.defaultReadObject();
		int x = ois.readInt();
		int y = ois.readInt();
		initialize(x, y);

	}

	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
		oos.writeInt(getX());
		oos.writeInt(getY());
	}

	public Foo(int x, int y) {
		super(x, y);
	}

}
