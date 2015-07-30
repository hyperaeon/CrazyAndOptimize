package com.crazy.chapter15.duplicate;

import java.io.FileReader;
import java.io.IOException;

import com.crazy.Constants;

public class FileReaderTest {

	public static void main(String[] args) throws IOException {
		try (FileReader reader = new FileReader(Constants.basicPath
				+ "/chapter15/duplicate/FileReaderTest.java")) {
			char[] cbuf = new char[32];
			int hasRead = 0;
			while ((hasRead = reader.read(cbuf)) > 0) {
				System.out.print(new String(cbuf, 0, hasRead));
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}
