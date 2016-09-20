package com.netease.enums;

public enum AccumulationType {

	NULL(-1, "NULL"),
	
	ACCUMULATION(0, "公积金"),
	
	ALLOWANCE(1, "房补公积金");
	
	private int value;
	
	private String desc;
	
	private AccumulationType(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	public int getValue() {
		return value;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public AccumulationType getEnumByIntValue(int intValue) {
		for (AccumulationType type : AccumulationType.values()) {
			if (type.getValue() == intValue) {
				return type;
			}
		}
		return NULL;
	}
}
