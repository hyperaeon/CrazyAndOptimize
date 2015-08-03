package com.crontab;

import java.util.ArrayList;
import java.util.List;

/**
 * When cucumber test runs by several teams, there are always conflict on
 * database The filter is to minimize the scope of normal size calculation
 * 
 * @author e518155
 *
 */
public class JsonCalculationFilter {

	// Only the order's that contains any one of logNumKeyArr will be in scope
	// of calculation
	private List<String> logNumKeyList;

	// Only the normal size that for any one of custIdArr will be updated in
	// order_normal_size table
	private List<String> custIdList;

	// Only the normal size that for any one of ccyPairArr will be updated in
	// order_normal_size table
	// To reduce complexity, it is supposed to have both side of currency in
	// request
	// A currency pair should be exactly like AUDUSD, length 6
	private List<String> ccyPairList;

	public List<String> getLogNumKeyList() {
		return logNumKeyList;
	}

	public void addLogNumKey(String logNumKey) {
		if (this.logNumKeyList == null) {
			this.logNumKeyList = new ArrayList<String>();
		}
		this.logNumKeyList.add(logNumKey);
	}

	public List<String> getCustIdList() {
		return custIdList;
	}

	public void addCustId(String custId) {
		if (this.custIdList == null) {
			this.custIdList = new ArrayList<String>();
		}
		this.custIdList.add(custId);
	}

	public List<String> getCcyPairList() {
		return ccyPairList;
	}

	public void addCcyPair(String ccyPair) {
		if (this.ccyPairList == null) {
			this.ccyPairList = new ArrayList<String>();
		}
		this.ccyPairList.add(ccyPair);
	}

	 /**
	 * returns a list of splited pair
	 * a splited pair is a list like {"AUD", "USD"}
	 * only the ccyPair that is length 6 will be parsed
	 */
	public List<List<String>> getSplitedCurrencyPairList() {
		if (ccyPairList == null) {
			return null;
		}
		List<List<String>> splitedList = new ArrayList<List<String>>();
		for (String ccyPair : ccyPairList) {
			if (ccyPair == null || ccyPair.length() != 6) {
				continue;
			}
			String ccy1 = ccyPair.substring(0, 3);
			String ccy2 = ccyPair.substring(3, 6);
			List<String> splitedPair = new ArrayList<String>();
			splitedPair.add(ccy1);
			splitedPair.add(ccy2);
			splitedList.add(splitedPair);
		}
		return splitedList;
	}

}
