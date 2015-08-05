package com.crontab;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;

public interface SchedulerService {

    /**
     * get scheduler underlying
     * @return
     */
    Scheduler getScheduler();

    /**
     * schedule the job with trigger
     * @param jobDetail
     * @param trigger
     * @return
     * @throws SchedulerException
     */
    boolean schedule(JobDetail jobDetail, Trigger trigger) throws SchedulerException;

    /**
     * trigger job now
     * @param jobName
     * @param groupName
     * @return
     * @throws SchedulerException
     */
    boolean triggerJob(String jobName, String groupName);

    /**
     * delete job
     * @param jobName
     * @param groupName
     * @return
     * @throws SchedulerException
     */
    boolean deleteJob(String jobName, String groupName);

    /**
     * set the flag of overwriting existing jobs, which is false default
     * @param overwriteExistingJobs
     */
    void setOverwriteExistingJobs(boolean overwriteExistingJobs);

}
