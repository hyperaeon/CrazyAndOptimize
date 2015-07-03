package com.test;

public class InvestManagerFund {

	private String investManagerName;
	private String fund;
	private String custId;
	public String getInvestManagerName() {
		return investManagerName;
	}
	public void setInvestManagerName(String investManagerName) {
		this.investManagerName = investManagerName;
	}
	public String getFund() {
		return fund;
	}
	public void setFund(String fund) {
		this.fund = fund;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	@Override
	public String toString() {
		return "InvestManagerFund [investManagerName=" + investManagerName
				+ ", fund=" + fund + ", custId=" + custId + "]";
	}
	
	
	
	
}
