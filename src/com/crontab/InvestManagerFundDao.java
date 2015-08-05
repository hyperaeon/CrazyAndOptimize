package com.crontab;

import java.util.List;

import javax.sql.DataSource;

import com.test.InvestManagerFund;

public interface InvestManagerFundDao {

	void setLegacyOMSDataSource(final DataSource dataSource);
	
	List<InvestManagerFund> fuzzySearchByImAndFund(String im, String fund) throws OrderValidationException;
	
	List<String> getCurrencyList() throws OrderValidationException;

	List<JsonImFund> queryCustIdByFund(JsonImFund jsonObj) throws OrderValidationException;

	String isFundExist(String custName) throws OrderValidationException;

	boolean isCustIdExist(String custId) throws OrderValidationException;
}
