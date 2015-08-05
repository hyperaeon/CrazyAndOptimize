package com.crontab;

public class SqlParameter {
	/** SQL type constant from java.sql.Types */
	private final int sqlType;

	/** The name of the parameter, if any */
	private String name;
	
	/**
	 * Create a new anonymous SqlParameter, supplying the SQL type.
	 * @param sqlType SQL type of the parameter according to java.sql.Types
	 */
	public SqlParameter(int sqlType) {
		this.sqlType = sqlType;
	}
	/**
	 * Create a new SqlParameter, supplying name and SQL type.
	 * @param name name of the parameter
	 * @param sqlType SQL type of the parameter according to java.sql.Types
	 */
	public SqlParameter(String name, int sqlType) {
		this.name = name;
		this.sqlType = sqlType;
	}	
	/**
	 * Return the SQL type of the parameter.
	 */
	public int getSqlType() {
		return this.sqlType;
	}

	/**
	 * Return the name of the parameter.
	 */
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return "SqlParameter [sqlType=" + sqlType + ", name=" + name + "]";
	}
}
