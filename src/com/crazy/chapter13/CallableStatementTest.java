package com.crazy.chapter13;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Properties;

public class CallableStatementTest {

	private String driver;
	private String url;
	private String user;
	private String pass;

	public void init(String paramFile) throws Exception {
		Properties props = new Properties();
		props.load(new FileInputStream(paramFile));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
	}

	public void callProcedure() throws Exception {
		Class.forName(driver);
		try (Connection conn = DriverManager.getConnection(url, user, pass);
				CallableStatement cstmt = conn
						.prepareCall("{call add_pro(?,?,?)}")) {
			cstmt.setInt(1, 4);
			cstmt.setInt(2, 5);
			cstmt.registerOutParameter(3, Types.INTEGER);
			cstmt.execute();
			System.out.println("执行结果是： " + cstmt.getInt(3));
		}
	}

	public static void main(String[] args) throws Exception {
		CallableStatementTest cst = new CallableStatementTest();
		cst.init(Constant.filePath);
		cst.callProcedure();
	}
}
