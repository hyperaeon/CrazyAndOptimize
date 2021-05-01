/**
 * 
 */
package com.crazy.chapter17.duplicate.simpleAIO;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;

/**
 * @author ly
 *
 */
public class SimpleAIOClient {

	private static final int PORT = 30000;
	
	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		Charset charset = Charset.forName("UTF-8");
		try (AsynchronousSocketChannel clientChannel = AsynchronousSocketChannel.open()) {
			clientChannel.connect(new InetSocketAddress("localhost",PORT)).get();
			buffer.clear();
			clientChannel.read(buffer).get();
			buffer.flip();
			String content = charset.decode(buffer).toString();
			System.out.println("服务器信息：" + content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
