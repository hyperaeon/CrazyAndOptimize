package com.test;

public class HiveDemo01 {

	static TSocket transport;
	
	private static Client getClient(String hiveServer, Integer hivePort) {
		final int SOME_BIG_NUMBER = 99999999;
		Client client = null;
		try {
			transport = new TSocket(hiveServer, hivePort);
			transport.setTimeout(SOME_BIG_NUMBER);
			transport.open();
			TBinaryProtocol protocol = new TBinaryProtocol(transport);
			client = new ThiftHive.Client(protocol);
			System.out.println("Connection is established");
			return client;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		 String HIVE_SERVER = "localhost";
		 Integer HIVE_PORT = new Integer(10000);
		 Client client = getClient(HIVE_SERVER, HIVE_PORT);
		 transport.close();
	}
}
