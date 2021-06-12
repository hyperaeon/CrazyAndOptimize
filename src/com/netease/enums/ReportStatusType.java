
package com.netease.enums;

/**
 * 报告状态
 * @author ly
 *
 */
public enum ReportStatusType {

	NULL(-1, "未知"),
	
	UNAPPLY(0, "未申请"),
	
	APPLYING(1, "申请中"),
	
	REPORTFINISH(2, "报告已出");
	
	private int value;
	
	private String desc;
	
	private ReportStatusType(int value, String desc) {
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

