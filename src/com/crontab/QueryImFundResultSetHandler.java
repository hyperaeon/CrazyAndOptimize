package com.crontab;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.test.InvestManagerFund;

public class QueryImFundResultSetHandler implements
		ResultSetHandler<List<InvestManagerFund>> {

	private static final Logger LOGGER = Logger
		    .getLogger(QueryImFundResultSetHandler.class);
	

	@Override
	public List<InvestManagerFund> handle(ResultSet rs) throws SQLException {
		List<InvestManagerFund> fundList = new ArrayList<InvestManagerFund>();
		
		LOGGER.debug("-----------------IN QueryImFundResultSetHandler ---------------");
		while (rs.next()) {		
			InvestManagerFund investManagerFund = new InvestManagerFund();
			String investManagerName = rs.getString("INVST_MGR_NM");
			String fund = rs.getString("CUST_SHRT_NM");
			String custId = rs.getString("CUST_ID");
			investManagerFund.setInvestManagerName(investManagerName);
			investManagerFund.setFund(fund);
			investManagerFund.setCustId(custId);
			fundList.add(investManagerFund);
		}
		LOGGER.debug("Fund count: " + fundList.size());
		return fundList;
	}


}
