package com.util;

public class SqlUtils {

	private static String COMMA = ",";
	private static String INSERT_PREFIX = "insert into ";
	
	private static String FILE_PATH = "E:\\Doc\\秀品\\";

	public static String insertSql(String table, int firstId, String... values) {
		StringBuilder sb = new StringBuilder();
		for (String value : values) {
			sb.append(INSERT_PREFIX).append(table).append(firstId).append(value);
		}
		
		return null;
	}
}
