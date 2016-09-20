package com.netease.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.netease.domain.Loan_Record_Detail;

public interface Loan_Record_DetailRepository extends CrudRepository<Loan_Record_Detail, Integer> {
	// 查找某种账户类型某种状态的账户
	List<Loan_Record_Detail> findByReportIdAndAccountTypeAndDetailType(Integer reportId,Integer accountType,Integer detailType);
}
