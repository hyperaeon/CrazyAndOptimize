package com.netease.enums;

/**
 * 报告查询原因
 * @author ly
 *
 */
public enum CheckReasonType {

	NULL(-1, "NULL"),
	
	CREDITAUDIT(0, "信用卡审批"),
	
	AFTERLOANMANAGE(1, "贷后管理"),
	
	AFTERLOANAUDIT(2, "贷后审批"),
	
	PERSONALCHECK(3, "个人查询"),
	
	GARANTEEAUDIT(4, "担保资格审查"),
	
	LOANAUDIT(5, "贷款审批");
	
	private int value;
	
	private String desc;
	
	private CheckReasonType(int value, String desc) {
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
	 * 根据描述获取value值
	 * @param desc
	 * @return
	 */
	public int getValueByDesc(String desc) {
		for (CheckReasonType type : CheckReasonType.values()) {
			if (type.getDesc().equals(desc)) {
				return type.getValue();
			}
		}
		return NULL.getValue();
	}
}
