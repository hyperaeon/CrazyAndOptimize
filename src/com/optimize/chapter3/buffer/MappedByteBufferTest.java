package com.optimize.chapter3.buffer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedByteBufferTest {

	private static final int NUM = 1024;
	
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(
				"D:\\Program\\workspace-kepler\\CrazyJava\\a.txt", "rw");
		FileChannel fc = raf.getChannel();
		MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0,
				raf.length());
		while (mbb.hasRemaining()) {
			System.out.print((char) mbb.get());
		}
		mbb.put(0, (byte) 57);
		raf.close();
	}
	
	private static void writeInByteBuffer() {
		try (
				FileOutputStream fout = new FileOutputStream(new File("D:/tmp/tmp.txt"));
				FileChannel fc = fout.getChannel();) {
			ByteBuffer byteBuffer = ByteBuffer.allocate(NUM);
			for (int i = 0; i < NUM * 4; i++) {
				byteBuffer.put(int2byte(i));
			}
			byteBuffer.flip();
			fc.write(byteBuffer);
		} catch (IOException e) {
			
		}
	}
	
	private static void readInByteBuffer() {
		try (
				FileInputStream fis = new FileInputStream(new File("D:/tmp/tmp.txt"));
				FileChannel fc = fis.getChannel();) {
			ByteBuffer byteBuffer = ByteBuffer.allocate(NUM * 4);
			fc.read(byteBuffer);
			byteBuffer.flip();
			while (byteBuffer.hasRemaining()) {
				byte2int(byteBuffer.get(), byteBuffer.get(), byteBuffer.get(), byteBuffer.get());
			}
		} catch (Exception e) {
			
		}
				
	}
	
	private static void writeInMappedByteBuffer() {
		try (
			FileChannel fc = new RandomAccessFile("d:/temp/tmp.txt", "rw").getChannel();) {
			IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, NUM * 4).asIntBuffer();
			for (int i = 0; i < NUM; i++) {
				ib.put(i);
			}
		} catch (Exception e) {
			
		}
	}
	
	private static void readInMappedByteBuffer() {
		try (FileChannel fc = new FileInputStream("d:/tmp/tmp.txt").getChannel();) {
			IntBuffer ib = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size()).asIntBuffer();
			while (ib.hasRemaining()) {
				ib.get();
			}
		} catch (Exception e) {
			
		}
	}
	private static int byte2int(byte b1, byte b2, byte b3, byte b4) {
		return ((b1 & 0xff) << 24) | ((b2 & 0xff) << 16) | ((b3 & 0xff) << 8) | (b4 & 0xff);
	}

	private static byte[] int2byte(int num) {
		byte[] result = new byte[4];
		result[0] = (byte)(num & 0xff);
		result[1] = (byte)((num >> 8) & 0xff);
		result[2] = (byte)((num >> 16) & 0xff);
		result[1] = (byte)(num >>> 24);
		return result;
	}
}
