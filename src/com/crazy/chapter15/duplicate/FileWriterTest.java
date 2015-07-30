package com.crazy.chapter15.duplicate;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	public static void main(String[] args) {
		try(FileWriter fw = new FileWriter(Constants.basicPath + "poem.txt")) {
			fw.write("abcdsefa\r\n");
			fw.write("asdfawef\r\n");
			fw.write("asdfawef\r\n");
			fw.write("asdfawef\r\n");
			fw.write("°¢·½Ë÷¶Ì·¢\r\n");
		} catch (IOException e) {
			
		}
	}
}
