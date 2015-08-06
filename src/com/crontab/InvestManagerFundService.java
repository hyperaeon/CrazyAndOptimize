package com.crontab;

import java.util.List;

import com.test.InvestManagerFund;

/**
 * Service of finding fund and cust_id.
 * 
 * @author a588727
 *
 */
public interface InvestManagerFundService {

	void setInvestManagerFundDao(InvestManagerFundDao dao);

	List<InvestManagerFund> fuzzySearchByImAndFund(String im, String fund) throws OrderValidationException;
	
	OrderValidationContext getContext();

	void setContext(OrderValidationContext context);
	
	boolean queryCustIdByFund();
	
	List<String> getCurrencyList() throws OrderValidationException;

	String isFundExist(String fund) throws OrderValidationException;

	boolean isCustIdExist(String custId)  throws OrderValidationException;
	
}
