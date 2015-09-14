/**
 * 
 */
package com.crazy.chapter17.duplicate.simpleAIO;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

/**
 * @author hzliyong
 *
 */
public class SimpleAIOServer {

	private static final int PORT = 30000;
	
	public static void main(String[] args) {
		try (AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open()) {
			serverChannel.bind(new InetSocketAddress(PORT));
			while (true) {
				Future<AsynchronousSocketChannel> future = serverChannel.accept();
				AsynchronousSocketChannel channel = future.get();
				channel.write(ByteBuffer.wrap("Welcome to AIO".getBytes("UTF-8"))).get();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
