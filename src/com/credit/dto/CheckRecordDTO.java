package com.credit.dto;

import java.util.List;

public class CheckRecordDTO {

	private List<CheckRecordDetailDTO> organizationCheckList;//机构查询记录明细
	
	private List<CheckRecordDetailDTO> personalCheckList;//个人查询记录明细

	public List<CheckRecordDetailDTO> getOrganizationCheckList() {
		return organizationCheckList;
	}

	public void setOrganizationCheckList(
			List<CheckRecordDetailDTO> organizationCheckList) {
		this.organizationCheckList = organizationCheckList;
	}

	public List<CheckRecordDetailDTO> getPersonalCheckList() {
		return personalCheckList;
	}

	public void setPersonalCheckList(List<CheckRecordDetailDTO> personalCheckList) {
		this.personalCheckList = personalCheckList;
	}
	
	
}
