package com.crontab;

import com.ssc.ssgm.fx.nba.service.OrderNormalSizeService;
import com.ssc.ssgm.fx.nba.service.ServiceFactory;
import com.ssc.ssgm.fx.nba.service.impl.OrderNormalSizeServiceImpl;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.Serializable;

/**
 * job for calculate normal size of trades
 */
public class NormalSizeCalculationJob implements Job, Serializable {

    private static final Logger LOGGER = Logger.getLogger(NormalSizeCalculationJob.class);

    private static final String CXCODE = "CX825";

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        LOGGER.info("calculate normal size of trades starts...");
        try {
            // get service from service factory
            OrderNormalSizeService service
                    = (OrderNormalSizeService)ServiceFactory.getInstance()
                        .findService(OrderNormalSizeServiceImpl.class.getName());

            String result = service.calculateAllNormalSize();
            if (!"Success".equals(result)) {
                LOGGER.fatal(String.format("%s %s", CXCODE, result));
            }

        } catch(Exception exp) {
            LOGGER.fatal(String.format("%s failed to calculate normal size due to exception raised: %s", CXCODE, exp.getMessage()));
            LOGGER.error("failed to calculate normal size due to exception raised", exp);
        } finally {
            LOGGER.info("end of calculating normal size of trades");
        }

    }
}