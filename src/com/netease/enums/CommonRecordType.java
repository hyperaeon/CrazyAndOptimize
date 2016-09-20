package com.netease.enums;

public enum CommonRecordType {

	NULL(-1, "NULL"),
	
	TAXARREARS(0, "欠税记录"),
	
	CIVILJUDGEMENT(1, "民事判决记录"),
	
	FORCEEXECUTE(2, "强制执行记录"),
	
	ADMINISTRATIVEPENALTY(3, "行政处罚记录"),
	
	TELECOMARREARAGE(4, "电信欠费记录");
	
	private int value;
	
	private String desc;
	
	public int getValue() {
		return value;
	}
	
	public String getDesc() {
		return desc;
	}
	
	private CommonRecordType(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}
}
