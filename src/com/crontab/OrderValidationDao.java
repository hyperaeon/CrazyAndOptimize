package com.crontab;

import java.util.List;

import javax.sql.DataSource;

/**
 * Interface to get reference data from database.
 * 
 * @author e482588
 */
public interface OrderValidationDao {
    /**
     * @param dataSource
     *            is injected by spring container.
     */
    void setWSSDataSource(final DataSource dataSource);

	void addTiers(JsonOrderSizeTier t, String user) throws OrderValidationException;
	
	List<JsonOrderSizeTier> queryTiers(JsonOrderSizeTier t) throws OrderValidationException;

	JsonOrderNormalSize addNormalSize(JsonOrderNormalSize jsonObj, String user) throws OrderValidationException;

	List<JsonOrderNormalSize> queryNormalSize(JsonOrderNormalSize jsonObj) throws OrderValidationException;
	
	public List<JsonOrderNormalSize> updateNormalSize(List<JsonOrderNormalSize> normalSizes,
			String user,String time) throws OrderValidationException;
	
	public JsonCurrencyPairCutoff addCurrencyPairCutoff(JsonCurrencyPairCutoff jsonObj, String user) throws OrderValidationException;
	
	public String deleteCurrencyPairCutoff(String groupIds,String user) throws OrderValidationException;
	
	public List<JsonCurrencyPairCutoff> queryDeadline(JsonCurrencyPairCutoff jsonObj)  throws OrderValidationException;
	
	public String updateMinimalSize(JsonOrderSizeTier jsonOrderSizeTier,String user, String time) throws OrderValidationException;

	JsonOrderNormalSize addNormalSizeByCustId(JsonOrderNormalSize jsonObj, String user) throws OrderValidationException;
	
	public List<JsonCurrencyPairCutoff> updateDeadline(List<JsonCurrencyPairCutoff> list, String string, String time24) throws OrderValidationException;

	public String deleteTierAndMinimalSize(String generateGroupId, String user) throws OrderValidationException ;
	
	public String deleteGlobalHoliday(String globalHolidayIds, String user,String currentDate) throws OrderValidationException ;

	public JsonGlobalHoliday addGlobalHoliday(JsonGlobalHoliday jsonObj, String user) throws OrderValidationException ;
	
	public List<JsonPricingService> queryPricingService() throws OrderValidationException ;
}
