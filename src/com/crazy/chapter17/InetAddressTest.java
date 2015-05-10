package com.crazy.chapter17;

import java.net.InetAddress;

public class InetAddressTest {

	public static void main(String[] args) throws Exception {
		InetAddress address = InetAddress.getByName("www.baidu.com");
		System.out.println("Is reachable : " + address.isReachable(30000));
		System.out.println("IP: " + address.getHostAddress());

		InetAddress local = InetAddress
				.getByAddress(new byte[] { 127, 0, 0, 1 });
		System.out.println("Is reachable: " + local.isReachable(2000));
		System.out.println(local.getCanonicalHostName());
	}
}
