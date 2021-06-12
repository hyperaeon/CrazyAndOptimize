package com.netease.enums;

/**
 * 报告明细的类型
 * @author ly
 *
 */
public enum DetailType {

	NULL(-1, "NULL"),
	
	OVERDUEDEBIT(0, "发生过逾期的贷记卡账户明细"),
	
	NEVEROVERDUEDEBIT(1, "从未逾期过的贷记卡及透支未超过60天的准贷记卡账户明细"),
	
	OVERDUESIXTYDEBIT(2, "透支超过60天的准贷记卡账户明细"),
	
	OVERDUEACCOUNT(3, "发生过逾期的账户明细"),
	
	NEVEROVERDUEACCOUNT(4, "从未逾期过的账户明细");
	
	private int value;
	
	private String desc;
	
	private DetailType(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	public int getValue() {
		return value;
	}
	
	public String getDesc() {
		return desc;
	}
	
	/**
	 * 根据desc获取枚举类型
	 * @param desc
	 * @return
	 */
	public DetailType getEnumByDesc(String desc) {
		for (DetailType type : DetailType.values()) {
			if (type.getDesc().equals(desc)) {
				return type;
			}
		}
		return NULL;
	}
	
	/**
	 * 根据描述获取value值
	 * @param desc
	 * @return
	 */
	public int getValueByDesc(String desc) {
		for (DetailType type : DetailType.values()) {
			if (type.getDesc().equals(desc)) {
				return type.getValue();
			}
		}
		return NULL.getValue();
	}
}
