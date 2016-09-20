package com.netease.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.domain.Loan_Record_Detail;
import com.netease.enums.AccountType;
import com.netease.enums.DetailType;
import com.netease.repositories.Loan_Record_DetailRepository;


@Service
public class Loan_Record_DetailService {
	@Autowired
	Loan_Record_DetailRepository loan_Record_DetailRepository;
	
	//查找信用卡发生过逾期的贷记卡账户明细
	public List<Loan_Record_Detail> findCreditCardOverdue(Integer reportId){
		return loan_Record_DetailRepository.findByReportIdAndAccountTypeAndDetailType(reportId, 
				AccountType.CREDIT.getValue(), DetailType.OVERDUEDEBIT.getValue());
	}
	//查找信用卡从未逾期过的贷记卡及透支未超过60天的准贷记卡账户明细
	public List<Loan_Record_Detail> findCreditCardNoOverdue(Integer reportId){
		return loan_Record_DetailRepository.findByReportIdAndAccountTypeAndDetailType(reportId,
				AccountType.CREDIT.getValue() , DetailType.NEVEROVERDUEDEBIT.getValue());
	}
	//查找信用卡透支超过60天的贷记卡账户明细
	public List<Loan_Record_Detail> findCreditCardOverdueSixty(Integer reportId){
		return loan_Record_DetailRepository.findByReportIdAndAccountTypeAndDetailType(reportId,
				AccountType.CREDIT.getValue(),DetailType.OVERDUESIXTYDEBIT.getValue());
	}
	//查找住房贷款未逾期账户明细
	public List<Loan_Record_Detail> findHouserLoadNoOverdue(Integer reportId)
	{
		return loan_Record_DetailRepository.findByReportIdAndAccountTypeAndDetailType(reportId,
				AccountType.HOUSELOAN.getValue(), DetailType.NEVEROVERDUEACCOUNT.getValue());
	}
	//查找住房贷款发生过逾期的账户明细
	public List<Loan_Record_Detail> findHouserLoadOverdue(Integer reportId)
	{
		return loan_Record_DetailRepository.findByReportIdAndAccountTypeAndDetailType(reportId, 
				AccountType.HOUSELOAN.getValue(),DetailType.OVERDUEACCOUNT.getValue() );
	}
	//查找其他贷款未逾期账户明细
	public List<Loan_Record_Detail> findOtherLoadNoOverdue(Integer reportId)
	{
		return loan_Record_DetailRepository.findByReportIdAndAccountTypeAndDetailType(reportId,
				AccountType.OTHERLOAN.getValue(), DetailType.NEVEROVERDUEACCOUNT.getValue());
	}
	//查找其他贷款发生过逾期的账户明细
	public List<Loan_Record_Detail> findOtherLoadOverdue(Integer reportId)
	{
		return loan_Record_DetailRepository.findByReportIdAndAccountTypeAndDetailType(reportId, 
				AccountType.OTHERLOAN.getValue(), DetailType.OVERDUEACCOUNT.getValue());
	}
}
