package com.crazy.chapter13;

import java.io.FileInputStream;
import java.util.Properties;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class RowSetFactoryTest {

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
		pass = props.getProperty("user");
	}
	
	public void update (String sql) throws Exception {
		Class.forName(driver);
		RowSetFactory factory = RowSetProvider.newFactory();
		try(JdbcRowSet jdbcRs = factory.createJdbcRowSet()) {
			jdbcRs.setUrl(url);
			jdbcRs.setUsername(user);
			jdbcRs.setPassword(pass);
			jdbcRs.setCommand(sql);
			jdbcRs.execute();
			jdbcRs.afterLast();
			while (jdbcRs.previous()) {
				System.out.println(jdbcRs.getString(1) + "\t"
						+ jdbcRs.getString(2) + "\t" + jdbcRs.getString(3));
				if (jdbcRs.getInt("jdbc_id") == 701) {
					jdbcRs.updateString("jdbc_name", "ÀÔ––’ﬂ");
					jdbcRs.updateRow();
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		RowSetFactoryTest jt = new RowSetFactoryTest();
		jt.initParam(Constant.filePath);
		jt.update("select * from jdbc_test");
	}
}
