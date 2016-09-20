package com.netease.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.netease.domain.ApiLog;
import com.netease.repositories.ApiLogRepository;

/**
 * 
 * @ClassName: ApiLogService
 * @Description: TODO
 * @author:JonneyZhang
 * @date: 2016年3月16日 下午6:49:55
 */
@Service
public class ApiLogService {
    @Autowired
    private ApiLogRepository apiLogRepository;

    public List<ApiLog> getAll(int page, int size) {
    	PageRequest pageRequest = new PageRequest(page - 1, size);
        return apiLogRepository.findAll(pageRequest);
    }
    public List<ApiLog> getAll() {

        return (List<ApiLog>) apiLogRepository.findAll();
    }

    public ApiLog save(ApiLog apiLog) {
        return apiLogRepository.save(apiLog);
    }
}
