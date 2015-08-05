package com.crontab;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class QueryCurrencyResultSetHandler implements
		ResultSetHandler<List<String>> {
	private static final Logger LOGGER = Logger
		    .getLogger(QueryCurrencyResultSetHandler.class);

	@Override
	public List<String> handle(ResultSet rs) throws SQLException {
		LOGGER.debug("-----------------IN Handle---------------");
		List<String> currencyList = new ArrayList<String>();
		while(rs.next()){
			currencyList.add(rs.getString("CRNCY_ID"));
		}
		LOGGER.debug("-----------------END Handle---------------");
		return currencyList;
	}

}
