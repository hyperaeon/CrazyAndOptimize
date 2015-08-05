package com.crontab;

public class JsonGlobalHoliday {

	private Integer globalHolidayId;
	
	private String globalHolidayName;
	
	private String globalHolidayDate;
	
	private String comments;
	
	protected String lastUpdatedById;

	protected Long lastUpdatedDttm;

	public Integer getGlobalHolidayId() {
		return globalHolidayId;
	}

	public void setGlobalHolidayId(Integer globalHolidayId) {
		this.globalHolidayId = globalHolidayId;
	}

	public String getGlobalHolidayName() {
		return globalHolidayName;
	}

	public void setGlobalHolidayName(String globalHolidayName) {
		this.globalHolidayName = globalHolidayName;
	}

	public String getGlobalHolidayDate() {
		return globalHolidayDate;
	}

	public void setGlobalHolidayDate(String globalHolidayDate) {
		this.globalHolidayDate = globalHolidayDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getLastUpdatedById() {
		return lastUpdatedById;
	}

	public void setLastUpdatedById(String lastUpdatedById) {
		this.lastUpdatedById = lastUpdatedById;
	}

	public Long getLastUpdatedDttm() {
		return lastUpdatedDttm;
	}

	public void setLastUpdatedDttm(Long lastUpdatedDttm) {
		this.lastUpdatedDttm = lastUpdatedDttm;
	}
	
}
