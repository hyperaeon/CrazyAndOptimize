package com.crontab;

import java.util.List;


public interface FxOrderService {
	void setFxOrderDao(FxOrderDao fxOrderDao);
	List<LegacyFxOrder> getFxOrderInRange(int dateRange, List<String> logNumKeyList);
}
