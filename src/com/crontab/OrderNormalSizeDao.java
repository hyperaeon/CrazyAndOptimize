package com.crontab;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.ssc.faw.util.GenException;

public interface OrderNormalSizeDao {
	void setDataSource(DataSource dataSource);

	public List<JsonOrderNormalSize> updateJsonOrderNormalSize(List<JsonOrderNormalSize> normalSizes, String user)
			throws Exception;

	public void deleteOrderNormalSize(String productCategoryId, String customerId, String ccy1, String ccy2)
			throws Exception;

	public JsonOrderNormalSize queryOrderNormalSize(String groupId, String customerId) throws Exception;

	/**
	 * save or update order normal size: 1. insert currency pair group if not exist 2. save or update normal size
	 * 
	 * @param normalSize
	 *            order normal size
	 * @param user
	 *            operator
	 */
	void saveCurrencyPairAndNormalSize(JsonOrderNormalSize normalSize, String user);

	public List<JsonOrderNormalSize> queryAllWithoutValue() throws Exception;
	
	public Map<String, BigDecimal> queryDefaultValue(String validationId) throws GenException;
}
