package com.netease.enums;

/**
 * 婚姻状态
 * @author hzliyong
 *
 */
public enum MarriageType {

	NULL (-1, "未知"),
	
	UNMARRIED(0, "未婚"),
	
	MARRIED(1, "已婚");
	
	private int value;
	
	private String desc;
	
	private MarriageType(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	public int getValue() {
		return value;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public MarriageType getEnumTypeByIntValue(int value) {
		for (MarriageType type : MarriageType.values()) {
			if (type.getValue() == value) {
				return type;
			}
		}
		return NULL;
	}
	
	/**
	 * 根据desc获取对应的value值
	 * @param desc
	 * @return
	 */
	public int getIntValueByDesc(String desc) {
		for (MarriageType type : MarriageType.values()) {
			if (type.getDesc().equals(desc)) {
				return type.getValue();
			}
		}
		return -1;
	}
}
