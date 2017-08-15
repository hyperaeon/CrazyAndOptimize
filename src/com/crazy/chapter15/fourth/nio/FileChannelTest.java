package com.crazy.chapter15.fourth.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class FileChannelTest {

	private static final String PATH = "C:\\Users\\hzliyong\\git\\CrazyAndOptimize\\src\\com\\crazy\\chapter15\\fourth\\nio\\FileChannelTest.java";
	
	private static final String RESOURCE = "C:\\Users\\hzliyong\\git\\CrazyAndOptimize\\src\\main\\resources\\file\\channel.txt";
	
	public static void main(String[] args) {
		File f = new File(PATH);
		try (FileChannel inChannel = new FileInputStream(f).getChannel();
				FileChannel outChannel = new FileOutputStream(RESOURCE).getChannel();) {
			MappedByteBuffer buffer = inChannel.map(FileChannel.
					MapMode.READ_ONLY, 0, f.length());
			Charset charset = Charset.forName("GBK");
			outChannel.write(buffer);
			buffer.clear();
			CharsetDecoder decoder = charset.newDecoder();
			CharBuffer charBuffer = decoder.decode(buffer);
			System.out.println(charBuffer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
