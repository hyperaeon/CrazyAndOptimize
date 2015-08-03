package com.crontab;

import com.ssc.ssgm.fx.nba.dao.NbaResourceConfigDao;
import com.ssc.ssgm.fx.nba.dao.OrderNormalSizeDao;
import com.ssc.ssgm.fx.nba.dao.PricingServiceDao;
import com.ssc.ssgm.fx.nba.helper.Calculator;
import com.ssc.ssgm.fx.nba.legacy.service.FxOrderService;

public interface OrderNormalSizeService {
	void setFxOrderService(FxOrderService fxOrderService);

	void setOrderNormalSizeDao(OrderNormalSizeDao orderNormalSizeDao);

	void setPricingServiceDao(PricingServiceDao pricingServiceDao);

	void setNbaResourceConfigDao(NbaResourceConfigDao nbaResourceConfigDao);
	
	String calculateAllNormalSize();

	/**
	 * 
	 * @param calculator: it is the normal size calculation strategy, average, medium or maximum
	 * @param user: who triggers this calculation
	 * @param filterJson: it should be null for prod. And it is to reduce the calculation scope for testing
	 * @return
	 */
	String calculateAllNormalSize(Calculator calculator, String user, String filterJson);

	void deleteOrderNormalSize(String productCategoryId, String customerId, String ccy1, String ccy2);

	/**
	 * calc normal size as needed: <br/>
	 * if the flag in config table is Y, then calc size no matter the size existed or not
	 */
	void calculateNormalSizeAsNeeded();
}
