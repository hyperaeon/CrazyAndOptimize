package com.crazy.chapter13;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Properties;

public class ExecuteSQL {

	private String driver;
	private String url;
	private String user;
	private String pass;

	public void initParam(String paramFile) throws Exception {
		Properties props = new Properties();
		props.load(new FileInputStream(paramFile));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
	}

	public void executeSql(String sql) throws Exception {
		Class.forName(driver);
		try (Connection conn = DriverManager.getConnection(url, user, pass);
				Statement stmt = conn.createStatement()) {
			boolean hasResultSet = stmt.execute(sql);
			if (hasResultSet) {
				try (ResultSet rs = stmt.getResultSet()) {
					ResultSetMetaData rsmd = rs.getMetaData();
					int columnCount = rsmd.getColumnCount();
					while (rs.next()) {
						for (int i = 0; i < columnCount; i++) {
							System.out.println(rs.getString(i + 1) + "\t");
						}
						System.out.println("\n");
					}
				}
			} else {
				System.out.println("该SQL语句影响的记录有：" + stmt.getUpdateCount()
						+ "条");
			}
		}
	}

	public static void main(String[] args) throws Exception {
		ExecuteSQL es = new ExecuteSQL();
		es.initParam(Constant.filePath);

		System.out.println("-----执行删除表的DDL语句-----");
		es.executeSql("drop table if exists my_test");

		System.out.println("-----执行建表的DDL语句-----");
		es.executeSql("create table my_test(test_id int auto_increment primary key, test_name varchar(255))");
		
		System.out.println("-----执行插入数据的DML语句-----");
		es.executeSql("insert into my_test(test_name) "
				+ "select jdbc_name from jdbc_test");
		
		System.out.println("-----执行查询语句-----");
		es.executeSql("select * from my_test");
	}
}
