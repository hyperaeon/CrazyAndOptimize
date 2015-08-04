package com.crontab;

import java.util.List;

import javax.sql.DataSource;

import com.ssc.faw.util.GenException;
import com.ssc.ssgm.fx.nba.model.PricingService;

public interface PricingServiceDao {
	void initJdbcCall(DataSource dataSource);
	List<PricingService> loadAll() throws GenException;
}
