package com.crazy.chapter15.fourth.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


public class WriteObject {

	private static final String path = "C:\\Users\\hzliyong\\git\\CrazyAndOptimize\\src\\main\\resources\\file\\object.txt";
	
	public static void main(String[] args) {
		testOutputStreamInt();
		int a = 1234567;
		byte[] bytes = new byte[4];
		bytes = int2Bytes(a);
		System.out.println(bytes.toString());
		int b = bytes2Int(bytes);
		System.out.println(b);
	}
	
	public static void test() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
			Person person = new Person("Sun", 500);
			oos.writeObject(person);
			System.out.println(person);
		} catch (Exception e) {
			
		}
	}
	
	public static void testOutputStreamInt() {
		try (OutputStream os = new FileOutputStream(path)) {
			int a = 2333333;
			os.write(a);
			InputStream is = new FileInputStream(path);
			int b = is.read();
			System.out.println(b);
		} catch (Exception e) {
			
		}
	}
	
	/**
	 * 字节数组转化成int
	 * @param bytes
	 * @return
	 */
	public static int bytes2Int(byte[] bytes) {
		int num = bytes[3] & 0xFF;
		num |= ((bytes[2] << 8) & 0xFF00);
		num |= ((bytes[1] << 16) & 0xFF0000);
		num |= ((bytes[0] << 24) & 0xFF000000);
		return num;
	}
	
	/**
	 * int转换成字节数组
	 * @param a
	 * @return
	 */
	public static byte[] int2Bytes(int a) {
		byte[] bytes = new byte[4];
		bytes[0] = (byte)((a >> 24) & 0xFF);
		bytes[1] = (byte)((a >> 16) & 0xFF);
		bytes[2] = (byte)((a >> 8) & 0xFF);
		bytes[3] = (byte)(a & 0xFF);
		return bytes;
		
				
	}
}
