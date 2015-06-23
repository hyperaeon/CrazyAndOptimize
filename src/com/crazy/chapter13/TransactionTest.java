package com.crazy.chapter13;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class TransactionTest {

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
	
	public void insertInTransaction(String[] sqls) throws Exception {
		Class.forName(driver);
		try (Connection conn = DriverManager.getConnection(url, user, pass)) {
			conn.setAutoCommit(false);
			try (Statement stmt = conn.createStatement()) {
				for (String sql : sqls) {
					stmt.executeUpdate(sql);
				}
			}
			conn.commit();
		}
	}
	
	public static void main(String[] args) throws Exception {
		TransactionTest tt = new TransactionTest();
		tt.initParam(Constant.filePath);
		String[] sqls = new String[] {
				"insert into jdbc_test values(null, 'aaa', 1)",
				"insert into jdbc_test values(null, 'bbb', 1)",
				"insert into jdbc_test values(null, 'ccc', 1)",
				"insert into jdbc_test values(null, 'ccc', 1)",
		};
		tt.insertInTransaction(sqls);
	}
}
