package com.netease.dto;

import java.util.ArrayList;
import java.util.List;

import com.netease.enums.AccountType;

/**
 * 封装信贷记录明细
 * @author hzliyong
 *
 */
public class LoanDetailDTO {

	private AccountType accountType;//信贷类型
	
	private String detailName;//信贷明细名称，如“从未逾期过的账户明细”
	
	private List<String> detailList = new ArrayList<String>();//明细内容列表

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public String getDetailName() {
		return detailName;
	}

	public void setDetailName(String detailName) {
		this.detailName = detailName;
	}

	public List<String> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<String> detailList) {
		this.detailList = detailList;
	}
	
}
