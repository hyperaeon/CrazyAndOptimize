package com.crazy.chapter13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnMySql {

	public static void main(String[] args) throws Exception {
		connectDB();
	}

	public static void connectDB() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/jpa", "root", "root");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from person_table");
			while (rs.next()) {
				System.out
						.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {

				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
