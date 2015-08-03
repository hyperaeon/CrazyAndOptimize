package com.crontab;

import com.ssc.ssgm.fx.nba.dao.OrderNormalSizeDao;
import com.ssc.ssgm.fx.nba.dao.OrderValidationDao;
import com.ssc.ssgm.fx.nba.dao.PricingServiceDao;
import com.ssc.ssgm.fx.nba.dao.impl.NbaResourceConfigDaoImpl;
import com.ssc.ssgm.fx.nba.dao.impl.OrderNormalSizeDaoImpl;
import com.ssc.ssgm.fx.nba.dao.impl.OrderValidationDaoImpl;
import com.ssc.ssgm.fx.nba.dao.InvestManagerFundDao;
import com.ssc.ssgm.fx.nba.dao.impl.InvestManagerFundDaoImpl;
import com.ssc.ssgm.fx.nba.dao.impl.PricingServiceDaoImpl;
import com.ssc.ssgm.fx.nba.dataaccess.CloudDataSource;
import com.ssc.ssgm.fx.nba.exception.ObjectNotFoundException;
import com.ssc.ssgm.fx.nba.legacy.dao.FxOrderDao;
import com.ssc.ssgm.fx.nba.legacy.dao.impl.FxOrderDaoImpl;
import com.ssc.ssgm.fx.nba.legacy.service.FxOrderService;
import com.ssc.ssgm.fx.nba.legacy.service.impl.FxOrderServiceImpl;
import com.ssc.ssgm.fx.nba.service.impl.QuartzServiceImpl;
import com.ssc.ssgm.fx.nba.service.impl.SchedulerServiceImpl;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * RefDataServiceFactory.
 * 
 * @author e523436
 * 
 */
public class ServiceFactory {

    private static final Logger LOGGER = Logger.getLogger(ServiceFactory.class);
    /**
     * Singleton instance of the workflow factory.
     */
    private static final ServiceFactory SINGLETON_INSTANCE = new ServiceFactory();
    
    private final Map<String, Object> serviceMap = new HashMap<String, Object>();

    /**
     * This method returns the singleton instance of the Factory.
     */
    public static ServiceFactory getInstance() {
        return SINGLETON_INSTANCE;
    }

    /**
     * Private constructor to instantiate the factory since the factory is a singleton class.
     */
    protected ServiceFactory() {
    	
    }


    /**
     * Returns a workflow instance for the given workflow id. Internally invokes spring container to
     * get a workflow bean and return it.
     * 
     * @param serviceName
     *            service ojbect class name
     * @throws ObjectNotFoundException
     */
    public synchronized Object findService(String serviceName) {

    	Object object = serviceMap.get(serviceName);
    	if (object == null) {
    		object = this.createService(serviceName);
    	}
        return object;

    }
    
    
    private Object createService(String serviceName) {
        Object service = null;
        try {
            service = Class.forName(serviceName).newInstance();
        } catch (Exception e) {
            LOGGER.error("Service not found: " + e.getMessage(), e);
            throw new ObjectNotFoundException("Service not found.", e);
        }

        if (service instanceof OrderValidationService) {
            initService((OrderValidationService) service);
        } else if (service instanceof InvestManagerFundService) {
        	initService((InvestManagerFundService) service);
        }

        if (service instanceof OrderNormalSizeService) {
        	initService((OrderNormalSizeService) service);
        }
        	
        // legacy OMS service
        if (service instanceof FxOrderService ){
        	initService((FxOrderService) service);
        }

        if (service instanceof QuartzService) {
            initService((QuartzService) service);
        }
        
        serviceMap.put(serviceName, service);
        return service;
    }

    private void initService(QuartzService service) {

        LOGGER.debug("init QuartzService begins ...");
        if (service instanceof QuartzServiceImpl) {
            QuartzServiceImpl serviceImpl = (QuartzServiceImpl)service;
            NbaResourceConfigDaoImpl dao = new NbaResourceConfigDaoImpl();
            dao.setDataSource(new CloudDataSource(CloudDataSource.NBA_DATASOURCE));
            serviceImpl.setConfigDao(dao);
            serviceImpl.setSchedulerService(new SchedulerServiceImpl());
        }

        LOGGER.debug("init QuartzService ends ...");
    }

    /**
     * init service object.
     * 
     * @param service
     */
    private void initService(OrderValidationService service) {
    	LOGGER.debug("init OrderValidationService begins ...");
        OrderValidationDao dao = new OrderValidationDaoImpl();
        dao.setWSSDataSource(new CloudDataSource(CloudDataSource.NBA_DATASOURCE));      
        service.setOrderValidationDao(dao);        
    }
    
    private void initService(InvestManagerFundService service) {
    	InvestManagerFundDao dao = new InvestManagerFundDaoImpl();
    	dao.setLegacyOMSDataSource(new CloudDataSource(CloudDataSource.LEGACY_OMS_DATASOURCE));
    	service.setInvestManagerFundDao(dao);
        LOGGER.debug("init OrderValidationService ends ...");
    }
    
    private void initService(OrderNormalSizeService service) {
    	LOGGER.debug("init OrderNormalSizeService begins ...");
    	DataSource dataSource = new CloudDataSource(CloudDataSource.NBA_DATASOURCE);
    	OrderNormalSizeDao orderNormalSizeDao = new OrderNormalSizeDaoImpl();
    	orderNormalSizeDao.setDataSource(dataSource);
    	service.setOrderNormalSizeDao(orderNormalSizeDao);
		PricingServiceDao psDao = new PricingServiceDaoImpl();
		psDao.initJdbcCall(dataSource);
		service.setPricingServiceDao(psDao);
        NbaResourceConfigDaoImpl nbaResourceConfigDao = new NbaResourceConfigDaoImpl();
        nbaResourceConfigDao.setDataSource(new CloudDataSource(CloudDataSource.NBA_DATASOURCE));
        service.setNbaResourceConfigDao(nbaResourceConfigDao);
		service.setFxOrderService((FxOrderService)findService(FxOrderServiceImpl.class.getName()));
		LOGGER.debug("init OrderNormalSizeService ends ...");
	}

	private void initService(FxOrderService service) {
		LOGGER.debug("init FxOrderService begins ...");
		FxOrderDao fxOrderDao = new FxOrderDaoImpl();
		fxOrderDao.setDataSource(new CloudDataSource(CloudDataSource.LEGACY_OMS_DATASOURCE));
		service.setFxOrderDao(fxOrderDao);
		LOGGER.debug("init FxOrderService ends ...");
	}
}
