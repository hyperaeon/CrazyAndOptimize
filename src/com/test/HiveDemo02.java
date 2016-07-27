package com.test;

public class HiveDemo02 {

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
	
	private Client show_database(Client cli) {
		try {
			try {
				cli.execute("show databases");
			} catch (Exception e) {
				e.printStackTrace();
			}
			List<String> list = null;
			try {
				list = cli.fetchAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("***The database List***");
			for (String str : list) {
				System.out.println(str);
			}
			System.out.println("----------------");
			Client cli2 = cli;
			return cli2;
		} finally {
		}
	}
	
	private Client create_databases(Client client) {
		try {
			client.execute("create database if not exists jdbc_demo");
		} catch (HiveServerException e) {
			e.printStackTrace();
		} catch (TException ex) {
			ex.printStackTrace();
		}
		System.out.println("***jdbc_demo Database is created***");
		System.out.println("-----------------------------------");
		Client client2 = client;
		return client2;
	}
	
	private Client use_databases(Client client, String db_name) {
		try {
			client.execute("use " + db_name);
		} catch (HiveServerExcepion e) {
			e.printStackTrace();
		} catch (TException ex) {
			ex.printStackTrace();
		}
		System.out.println("***changed database to " + db_name + "***");
		System.out.println("-----------------------------------");
		Client client2 = client;
		return client2;
	}
	public static void main(String[] args) {
		 String HIVE_SERVER = "localhost";
		 Integer HIVE_PORT = new Integer(10000);
		 Client client = getClient(HIVE_SERVER, HIVE_PORT);
		 HiveDemo02 demo = new HiveDemo02();
		 client = demo.show_database(client);
		 System.out.println(" Before Creating the database jdbc_demo ");
		 client = demo.create_database(client);
		 System.out.println(" After Creating the database jdbc_demo ");
		 client = demo.show_database(client);
		 System.out.println(" Changing to jdbc_demo Database ");
		 client = demo.use_databases(client, "jdbc_demo");
		 transport.close();
	}
}
