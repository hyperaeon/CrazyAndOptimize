/**
 * 
 */
package com.crazy.chapter17.duplicate.AIO;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ly
 *
 */
public class AIOServer {

	private static final int PORT = 30000;

	public static final String UTF_8 = "UTF-8";

	public static List<AsynchronousSocketChannel> channelList = new ArrayList<>();

	public void startListen() throws InterruptedException, Exception {
		ExecutorService executor = Executors.newFixedThreadPool(20);
		AsynchronousChannelGroup group = AsynchronousChannelGroup.withThreadPool(executor);
		AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open(group).bind(
				new InetSocketAddress(PORT));
		serverChannel.accept(null, new AcceptHandler(serverChannel));
	}
}

class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, Object> {
	private AsynchronousServerSocketChannel serverChannel;

	public AcceptHandler(AsynchronousServerSocketChannel asc) {
		this.serverChannel = asc;
	}

	ByteBuffer buffer = ByteBuffer.allocate(1024);

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.nio.channels.CompletionHandler#completed(java.lang.Object,
	 *      java.lang.Object)
	 */
	@Override
	public void completed(final AsynchronousSocketChannel sc, Object attachment) {
		AIOServer.channelList.add(sc);
		serverChannel.accept(null, this);
		sc.read(buffer, null, new CompletionHandler<Integer, Object>() {

			public void completed(Integer result, Object attachment) {
				buffer.flip();
				String content = StandardCharsets.UTF_8.decode(buffer).toString();
				for (AsynchronousSocketChannel c : AIOServer.channelList) {
					try {
						c.write(ByteBuffer.wrap(content.getBytes(AIOServer.UTF_8))).get();
					} catch (Exception e) {
						e.printStackTrace();
					}
					buffer.clear();
					sc.read(buffer, null, this);
				}
			}

			@Override
			public void failed(Throwable exc, Object attachment) {
				System.out.println("read failed: " + exc);
				AIOServer.channelList.remove(sc);
			}
		});

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.nio.channels.CompletionHandler#failed(java.lang.Throwable,
	 *      java.lang.Object)
	 */
	@Override
	public void failed(Throwable exc, Object attachment) {
		System.out.println("Connection faile: " + exc);
	}

}
