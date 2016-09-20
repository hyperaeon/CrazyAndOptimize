package com.netease.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.domain.Check_Record;
import com.netease.repositories.Check_RecordRepository;

@Service
public class Check_RecordService {
	
	@Autowired
	Check_RecordRepository check_RecordRepository;
	
	//查询信用卡审批
	public List<Check_Record> findCreditCardApproval(Integer reportId){
		return check_RecordRepository.findByReportIdAndQueryReason(reportId, "信用卡审批");
	}
	//查询贷后管理
	public List<Check_Record> findLoanAfterManager(Integer reportId){
		return check_RecordRepository.findByReportIdAndQueryReason(reportId, "贷后管理");
	}
	//查询贷款审批
	public List<Check_Record> findLoanApproval(Integer reportId){
		return check_RecordRepository.findByReportIdAndQueryReason(reportId, "贷款审批");
	}
	//查询个人查询
	public List<Check_Record> findPersonageQuery(Integer reportId){
		return check_RecordRepository.findByReportIdAndQueryReasonStartingWith(reportId, "本人");
	}
	//查询个人担保审查
}
