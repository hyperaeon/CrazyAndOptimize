package com.netease.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.netease.domain.Basic;

public interface BasicRepository extends CrudRepository<Basic, Integer>{
	public Basic save(Basic basic);
	public List<Basic> findAll();
	public List<Basic> findByUserIdOrderByReportTimeDesc(Integer userId);
	public Basic findByReportNumber(String reportNumber);
	public Basic findById(Integer id);
}
