package com.crazy.chapter13;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import javax.sql.rowset.JdbcRowSet;

public class JdbcRowSetTest {

	private String driver;
	private String url;
	private String user;
	private String pass;

	public void init(String param) throws Exception {
		Properties props = new Properties();
		props.load(new FileInputStream(param));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
	}

	public void update(String sql) throws Exception {
		Class.forName(driver);
//		try (Connection conn = DriverManager.getConnection(url, user, pass);
//				JdbcRowSet jdbcRs = new JdbcRowSetImpl(conn)) {
//			jdbcRs.setCommand(sql);
//			jdbcRs.execute();
//			jdbcRs.afterLast();
//			while (jdbcRs.previous()) {
//				System.out.println(jdbcRs.getString(1) + "\t"
//						+ jdbcRs.getString(2) + "\t" + jdbcRs.getString(3));
//				if (jdbcRs.getInt("jdbc_id") == 3) {
//					jdbcRs.updateString("jdbc_name", "ÀÔ––’ﬂ");
//					jdbcRs.updateRow();
//				}
//			}
//		}
	}
	
	public static void main(String[] args) throws Exception {
		JdbcRowSetTest jt = new JdbcRowSetTest();
		jt.init(Constant.filePath);
		jt.update("select * from jdbc_test");
	}
}
