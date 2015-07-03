package com.test;

import java.util.ArrayList;
import java.util.List;
import com.test.InvestManagerFund;


public class InvestManagerFundTest {

	public static void main(String[] args) {
		List<InvestManagerFund> fundList = new ArrayList<InvestManagerFund>();
		for (int i = 0; i < 40000; i++) {
			InvestManagerFund fund = new InvestManagerFund();
			fund.setCustId("custId " + i);
			fund.setFund("fund " + i);
			fund.setInvestManagerName("invest " + i);
			fundList.add(fund);
		}
		System.out.println(fundList.size());
	}
}
