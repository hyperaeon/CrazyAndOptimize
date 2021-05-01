package com.netease.enums;

/**
 * 查询记录的查询性质
 * @author ly
 *
 */
public enum CheckType {

	NULL(-1, "NULL"),
	
	ORGANIZATION(0, "机构查询"),
	
	PERSONAL(1, "个人查询");
	
	private int value;
	
	private String desc;
	
	private CheckType(int value, String desc) {
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
	public CheckType getEnumByDesc(String desc) {
		for (CheckType type : CheckType.values()) {
			if (type.getDesc().equals(desc)) {
				return type;
			}
		}
		return NULL;
	}
}
