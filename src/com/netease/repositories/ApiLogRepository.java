package com.netease.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.netease.domain.ApiLog;

/**
 * 
 * @ClassName: ApiLogRepository
 * @Description: TODO
 * @author:JonneyZhang
 * @date: 2016-5-17 09:55:23
 */
public interface ApiLogRepository extends CrudRepository<ApiLog, Long> {

	/**
	 * 查询所有的日志信息
	 */
    public List<ApiLog> findAll(Pageable pageable);


}
