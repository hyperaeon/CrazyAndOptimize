package com.crontab;

import java.util.List;


/**
 * Service of order validation.
 * 
 * @author e494837
 */
public interface OrderValidationService {
    /**
     * set ReferenceDataDao dao.
     * 
     * @param dao
     */
    void setOrderValidationDao(OrderValidationDao dao);
    
    OrderValidationContext getContext();

	void setContext(OrderValidationContext context);

    boolean addTiers();

    boolean queryTiers();
    
    String addNormalSize();

	boolean queryNormalSize();
    
    String updateNormalSize();

	boolean addDeadline() throws OrderValidationException;

	boolean queryDeadline();
	
	String deleteDeadline();
    
	OrderValidationContext updateMinimalSize(String json,String user);

	OrderValidationContext addNormalSizeByCustId(String json,String user);

	OrderValidationContext updateDeadline(String json,String user);

	OrderValidationContext deleteTierAndMinimalSize(String inputJson,
			String user);

	
	OrderValidationContext deleteGlobalHoliday(String inputJson,
			String user);

	OrderValidationContext addGlobalHoliday(String inputJson, String user);
	
	OrderValidationContext queryPricingService() throws OrderValidationException;
    
}
