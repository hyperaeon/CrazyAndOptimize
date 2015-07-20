package com.designpattern.flyweight.duplicate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class ConnectionPool {

	private Vector<Connection> pool;

	private String url = "";
	private String driverClassName = "";
	private String user = "";
	private String password = "";

	private static ConnectionPool instance = null;
	private int poolSize = 100;
	Connection conn = null;

	private ConnectionPool() {
		pool = new Vector<Connection>(poolSize);
		try {
			for (int i = 0; i < poolSize; i++) {
				Class.forName(driverClassName);
				conn = DriverManager.getConnection(url, user, password);
				pool.add(conn);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public synchronized void release() {
		pool.add(conn);
	}

	public synchronized Connection getConnection() {
		if (poolSize > 0) {
			Connection conn = pool.get(0);
			pool.remove(conn);
			return conn;
		} else {
			return null;
		}
	}

	public synchronized static ConnectionPool getInstance() {
		if (instance == null) {
			instance = new ConnectionPool();
		}
		return instance;
	}
}
