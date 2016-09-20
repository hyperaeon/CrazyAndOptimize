package com.netease.enums;

public enum SecurityLevelType {
	NULL(-1, "未知"),

	LOW(0, "低等级"),

	MIDDLE(1, "中等级"),

	HIGH(2, "高等级");

	private int value;

	private String desc;

	private SecurityLevelType(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
}
