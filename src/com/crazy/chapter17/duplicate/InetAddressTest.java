package com.crazy.chapter17.duplicate;

import java.net.InetAddress;

public class InetAddressTest {

	public static void main(String[] args) throws Exception {
		InetAddress ip = InetAddress.getByName("www.baidu.com");
		System.out.println("baidu是否可达：" + ip.isReachable(2000));
		System.out.println(ip.getHostAddress());
		InetAddress local = InetAddress
				.getByAddress(new byte[] { 127, 0, 0, 1 });
		System.out.println("local是否可达：" + local.isReachable(2000));
		System.out.println(local.getCanonicalHostName());
	}
}
