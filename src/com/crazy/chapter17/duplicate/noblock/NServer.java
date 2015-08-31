package com.crazy.chapter17.duplicate.noblock;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class NServer {

	private Selector selector = null;

	private final int PORT = 30000;

	private Charset charset = Charset.forName("UTF-8");

	public void init() throws IOException {
		selector = Selector.open();
		ServerSocketChannel server = ServerSocketChannel.open();
		InetSocketAddress isa = new InetSocketAddress("localhost", PORT);
		server.bind(isa);
		server.configureBlocking(false);
		server.register(selector, SelectionKey.OP_ACCEPT);
		while (selector.select() > 0) {
			for (SelectionKey sk : selector.selectedKeys()) {
				selector.selectedKeys().remove(sk);
				if (sk.isAcceptable()) {
					SocketChannel sc = server.accept();
					sc.configureBlocking(false);
					sc.register(selector, SelectionKey.OP_READ);
					sk.interestOps(SelectionKey.OP_ACCEPT);
				}
				if (sk.isReadable()) {
					SocketChannel sc = (SocketChannel) sk.channel();
					ByteBuffer buff = ByteBuffer.allocate(1024);
					String content = "";
					try {
						while (sc.read(buff) > 0) {
							buff.flip();
							content += charset.decode(buff);
						}
						System.out.println("The content of read is : "
								+ content);
						sk.interestOps(SelectionKey.OP_READ);
					} catch (IOException e) {
						sk.cancel();
						if (sk.channel() != null) {
							sk.channel().close();
						}
					}
					if (content.length() > 0) {
						for (SelectionKey key : selector.keys()) {
							Channel targetChannel = key.channel();
							if (targetChannel instanceof SocketChannel) {
								SocketChannel dest = (SocketChannel) targetChannel;
								dest.write(charset.encode(content));
							}
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		new NServer().init();
	}
}
