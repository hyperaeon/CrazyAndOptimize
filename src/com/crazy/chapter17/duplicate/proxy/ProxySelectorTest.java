/**
 * 
 */
package com.crazy.chapter17.duplicate.proxy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ly
 *
 */
public class ProxySelectorTest {

	private static final String PROXY_ADDR = "129.12.188.28";

	private static final int PROXY_PORT = 20000;

	String url_str = "http://www.crazyit.org";

	public void init() throws IOException, MalformedURLException {
		ProxySelector.setDefault(new ProxySelector() {

			@Override
			public List<Proxy> select(URI uri) {
				List<Proxy> result = new ArrayList<>();
				result.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(PROXY_ADDR, PROXY_PORT)));
				return result;
			}

			@Override
			public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
				System.out.println("failed");
			}
		});
		URL url = new URL(url_str);
		URLConnection connection = url.openConnection();
		connection.getInputStream();
	}

	public static void main(String[] args) throws IOException, MalformedURLException {
		new ProxySelectorTest().init();
	}
}
