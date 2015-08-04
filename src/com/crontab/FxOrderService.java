package com.crontab;

import java.util.List;

import com.ssc.ssgm.fx.nba.legacy.dao.FxOrderDao;
import com.ssc.ssgm.fx.nba.legacy.model.LegacyFxOrder;

public interface FxOrderService {
	void setFxOrderDao(FxOrderDao fxOrderDao);
	List<LegacyFxOrder> getFxOrderInRange(int dateRange, List<String> logNumKeyList);
}
