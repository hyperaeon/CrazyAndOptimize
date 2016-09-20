package com.netease.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.domain.Basic;
import com.netease.repositories.BasicRepository;


@Service
public class BasicService {

	@Autowired
    private BasicRepository basicRespository;
	public Basic save(Basic basic){
		return basicRespository.save(basic);
	}
	public List<Basic> findAll()
	{
		return basicRespository.findAll();
	}
	public List<Basic> findByUserIdOrderByReportTime(Integer userId)
	{
		return basicRespository.findByUserIdOrderByReportTimeDesc(userId);
	}
	public Basic findByReportNumber(String reportNumber){
		return basicRespository.findByReportNumber(reportNumber);
	}
	public Basic findByReportId(Integer id)
	{
		return basicRespository.findById(id);
	}
}
