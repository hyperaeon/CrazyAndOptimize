package com.crazy.chapter13;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class ExecuteDML {

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
	
	public int insertData(String sql) throws Exception {
		Class.forName(driver);
		try (Connection conn = DriverManager.getConnection(url,user,pass);
				Statement stmt = conn.createStatement()) {
			return stmt.executeUpdate(sql);
		}
	}
	
	public static void main(String[] args) throws Exception{
		ExecuteDML ed = new ExecuteDML();
		ed.initParam(Constant.filePath);
		int result = ed.insertData("insert into jdbc_test(jdbc_name,jdbc_desc)"
				+ " values('liyong', 'enroll')");
		System.out.println("系统共有" + result + "条记录受影响");
	}
}
