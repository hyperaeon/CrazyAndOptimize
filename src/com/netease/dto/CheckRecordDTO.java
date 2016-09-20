package com.netease.dto;

import java.util.ArrayList;
import java.util.List;

public class CheckRecordDTO {

	private List<CheckRecordDetailDTO> organizationCheckList = new ArrayList<CheckRecordDetailDTO>();//机构查询记录明细
	
	private List<CheckRecordDetailDTO> personalCheckList = new ArrayList<CheckRecordDetailDTO>();//个人查询记录明细

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
