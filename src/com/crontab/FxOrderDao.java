package com.crontab;

import java.util.List;

import javax.sql.DataSource;

import com.ssc.faw.util.GenException;

public interface FxOrderDao {
	void setDataSource(DataSource dataSource);
	List<LegacyFxOrder> getFxOrderInRange(int dateRange) throws GenException;
}
