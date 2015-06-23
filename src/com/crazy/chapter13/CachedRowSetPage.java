package com.crazy.chapter13;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class CachedRowSetPage {

	private static String driver;
	private static String url;
	private static String user;
	private static String pass;
	
	public void initParam(String paramFile) throws Exception {
		Properties props = new Properties();
		props.load(new FileInputStream(paramFile));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
	}
	
	public CachedRowSet query (String sql, int pageSize, int page) throws Exception {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pass);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		RowSetFactory factory = RowSetProvider.newFactory();
		CachedRowSet cachedRs = factory.createCachedRowSet();
		cachedRs.setPageSize(pageSize);
		cachedRs.populate(rs, (page - 1) * pageSize + 1);
		rs.close();
		stmt.close();
		conn.close();
		return cachedRs;
	}
	
	public static void main(String[] args) throws Exception {
		CachedRowSetPage ct = new CachedRowSetPage();
		ct.initParam(Constant.filePath);
		CachedRowSet rs = ct.query("select * from jdbc_test", 3, 2);
		while (rs.next()) {
			System.out.println(rs.getString(1)
					+ "\t" + rs.getString(2)
					+ "\t" + rs.getString(3));
		}
	}
}
