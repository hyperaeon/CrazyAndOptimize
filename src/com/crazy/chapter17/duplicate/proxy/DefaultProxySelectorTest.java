/**
 * 
 */
package com.crazy.chapter17.duplicate.proxy;

import java.net.ProxySelector;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author ly
 *
 */
public class DefaultProxySelectorTest {

	private static final String urlStr = "http://www.crazyit.org";

	public static void main(String[] args) throws Exception {
		Properties props = System.getProperties();
		props.setProperty("http.proxyHost", "192.168.10.96");
		props.setProperty("http.proxyPort", "8080");
		props.setProperty("http.nonProxyHosts", "localhost|192.168.10.*");

		props.setProperty("https.proxyHost", "192.168.10.96");
		props.setProperty("https.proxyPort", "443");
		// props.setProperty("https.nonProxyHosts", "localhost|192.168.10.*");

		props.setProperty("ftp.proxyHost", "192.168.10.96");
		props.setProperty("ftp.proxyPort", "2121");
		props.setProperty("ftp.nonProxyHosts", "localhost|192.168.10.*");

		props.setProperty("socks.proxyHost", "192.168.10.96");
		props.setProperty("socks.proxyPort", "1080");

		ProxySelector selector = ProxySelector.getDefault();
		System.out.println("Default seletor: " + selector);
		System.out.println("proxy server: " + ProxySelector.getDefault().select(new URI("http://www.crazyit.org")));
		URL url = new URL(urlStr);
		URLConnection conn = url.openConnection();
		try (Scanner scanner = new Scanner(conn.getInputStream(), "utf-8")) {
			while (scanner.hasNext()) {
				System.out.println(scanner.next());
			}
		}
	}
}
