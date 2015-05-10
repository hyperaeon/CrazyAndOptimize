package com.optimize.chapter3.nio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class PerformanceTest {

	private static String PATH = "D:\\Program\\workspace-kepler\\CrazyJava\\a.txt";

	public static void main(String[] args) throws IOException {
		int limit = 4000000;
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(
				new FileOutputStream(new File(PATH))));
		for (int i = 0; i < limit; i++) {
			dos.writeInt(i);
		}
		if (dos != null) {
			dos.close();
		}

		DataInputStream dis = new DataInputStream(new BufferedInputStream(
				new FileInputStream(new File(PATH))));
		for (int i = 0; i < limit; i ++) {
			dis.readInt();
		}
		if (dis != null) {
			dis.close();
		}
		
		FileOutputStream fout = new FileOutputStream(new File(PATH));
		FileChannel fc = fout.getChannel();
		ByteBuffer byteB = ByteBuffer.allocate(limit * 4);
		for (int i = 0; i < limit; i ++) {
			byteB.put(int2byte(i));
		}
		byteB.flip();
		fc.write(byteB);
		fout.close();
		
		FileInputStream fin = new FileInputStream(new File(PATH));
		FileChannel fcc = fin.getChannel();
		ByteBuffer byteBuffer = ByteBuffer.allocate(limit * 4);
		fcc.read(byteBuffer);
		fcc.close();
		fin.close();
		byteBuffer.flip();
		while(byteBuffer.hasRemaining()) {
			byte2int(byteBuffer.get(), byteBuffer.get(), byteBuffer.get(), byteBuffer.get());
		}
		
		int gt = 129;
		System.out.println(int2byte(gt)[0]);
	}

	private static byte[] int2byte(int res) {
		byte[] targets = new byte[4];
		targets[3] = (byte) (res & 0xff);
		targets[2] = (byte) ((res >> 8) & 0xff);
		targets[1] = (byte) ((res >> 16) & 0xff);
		targets[0] = (byte) (res >>> 24);
		return targets;
	}

	private static int byte2int(byte b1, byte b2, byte b3, byte b4) {
		return ((b1 & 0xff) << 24) | ((b2 & 0xff) << 16) | ((b3 & 0xff) << 8)
				| (b4 & 0xff);
	}
}
