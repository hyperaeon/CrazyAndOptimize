package com.crontab;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class SchedulerServiceImpl extends QuartzSchedulerHelper implements SchedulerService {

    private static final Logger LOGGER = Logger.getLogger(SchedulerServiceImpl.class);
    private static final String DEFAULT_QUARTZ_CONFIG_FILE = "quartz.properties";

    private static volatile Scheduler SCHEDULER;
    private static final Lock LOCK = new ReentrantLock();
    private static volatile boolean INITED = false;

    private static final Scheduler createScheduler(String config) {

        if (SCHEDULER == null) {
            LOCK.lock();
            try {
                // created or not
                if (!INITED) {
                    try {
                        SCHEDULER = new StdSchedulerFactory(config).getScheduler();
                        SCHEDULER.start();
                        INITED = true;
                    } catch (SchedulerException e) {
                        LOGGER.error("scheduler failed to start", e);
                    }
                }
            } finally {
                LOCK.unlock();
            }
        }

        return SCHEDULER;
    }

    @Override
    public Scheduler getScheduler() {

        return createScheduler(DEFAULT_QUARTZ_CONFIG_FILE);
    }

    @Override
    public boolean schedule(JobDetail jobDetail, Trigger trigger) throws SchedulerException {
        return addTriggerToScheduler(trigger, jobDetail);
    }

    @Override
    public boolean triggerJob(String jobName, String groupName) {

        try {
            boolean found = getScheduler().getJobDetail(jobName, groupName) != null;
            if (found) {
                getScheduler().triggerJob(jobName, groupName);
                return true;
            }
        } catch (SchedulerException e) {
            LOGGER.error("failed to trigger job", e);
        }

        return false;
    }

    @Override
    public boolean deleteJob(String jobName, String groupName) {
        try {
            boolean found = getScheduler().getJobDetail(jobName, groupName) != null;
            if (found) {
                getScheduler().deleteJob(jobName, groupName);
                return true;
            }
        } catch (SchedulerException e) {
            LOGGER.error("failed to trigger job", e);
        }

        return false;
    }
}
