package com.test;

public class HiveDemo03 {

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
	
	private Client show_tables(Client cli) {
		try {
			try {
				cli.execute("show tables");
			} catch (Exception e) {
				e.printStackTrace();
			}
			List<String> list = null;
			try {
				list = cli.fetchAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("***The table List***");
			for (String str : list) {
				System.out.println(str);
			}
			System.out.println("----------------");
			Client cli2 = cli;
			return cli2;
		} finally {
		}
	}
	
	private Client create_tables(Client client) {
		try {
			client.execute("create table sample_data(name string) stored as textfile");
		} catch (HiveServerException e) {
			e.printStackTrace();
		} catch (TException ex) {
			ex.printStackTrace();
		}
		System.out.println("***sample_data table is created***");
		System.out.println("-----------------------------------");
		Client client2 = client;
		return client2;
	}
	
	private Client load_data(Client client, String table_name) {
		try {
			client.execute("load data local inpath '/home/hadoop/temp/data/hiveProgram/sample.txt' into table"
					+ table_name);
		} catch (HiveServerExcepion e) {
			e.printStackTrace();
		} catch (TException ex) {
			ex.printStackTrace();
		}
		System.out.println("***load data into " + table_name + "***");
		System.out.println("-----------------------------------");
		Client client2 = client;
		return client2;
	}
	public static void main(String[] args) {
		 String HIVE_SERVER = "localhost";
		 Integer HIVE_PORT = new Integer(10000);
		 Client client = getClient(HIVE_SERVER, HIVE_PORT);
		 HiveDemo03 demo = new HiveDemo03();
		 client = demo.show_tables(client);
		 System.out.println(" Before Creating the table sample_data ");
		 client = demo.create_tables(client);
		 System.out.println(" After Creating the table sample_data ");
		 client = demo.show_tables(client);
		 System.out.println(" loading data into sample_data ");
		 client = demo.load_data(client, "sample_data");
		 transport.close();
	}
}
