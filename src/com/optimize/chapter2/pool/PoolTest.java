package com.optimize.chapter2.pool;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.DataSources;

public class PoolTest {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DataSource unpooled = DataSources.unpooledDataSource(
					"jdbc:mysql://localhost:3306/test","root","");
			DataSource pooled = DataSources.pooledDataSource(unpooled);
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			con = pooled.getConnection();
			System.out.println("con Class Type is:" + con.getClass().getName());
			Object o1 = getInner(con);
			System.out.println("Inner con Class Type is:" + o1.getClass().getName());
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM user");
			while (rs.next()) {
				System.out.println("Data from DB:" + rs.getString(1)); 
			}
			rs.close();
			stmt.close();
			con.close();
			Thread.sleep(1000);
			con = pooled.getConnection();
			Object o2 = getInner(con);
			if (o1 == o2) {
				System.out.println("o1 and o2 is same object.");
			}
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM user");
			while (rs.next()) {
				System.out.println("Data from DB:" + rs.getString(1));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Object getInner(Object con) {
		Object re = null;
		Field f;
		try {
			f = con.getClass().getDeclaredField("inner");
			f.setAccessible(true);
			re = f.get(con);
			f.setAccessible(false);
		} catch (Exception e) {
			
		}
		return re;
	}
}
