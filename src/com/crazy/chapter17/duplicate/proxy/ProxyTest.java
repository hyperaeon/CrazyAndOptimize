/**
 * 
 */
package com.crazy.chapter17.duplicate.proxy;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * @author ly
 *
 */
public class ProxyTest {

	private static final String PROXY_ADDR = "129.82.12.188";

	private static final int PROXY_PORT = 3124;

	private String str_url = "http://www.crazyit.org";

	public void init() throws IOException, MalformedURLException {
		URL url = new URL(str_url);
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(PROXY_ADDR, PROXY_PORT));
		URLConnection connection = url.openConnection(proxy);
		connection.setConnectTimeout(3000);
		try (Scanner scanner = new Scanner(connection.getInputStream()); PrintStream ps = new PrintStream("index.htm")) {
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				System.out.println(line);
				ps.println(ps);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		new ProxyTest().init();
	}
}
