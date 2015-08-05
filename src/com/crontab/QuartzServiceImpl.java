package com.crontab;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.quartz.*;

import java.text.ParseException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class QuartzServiceImpl  implements QuartzService {

    private static final Logger LOGGER = Logger.getLogger(QuartzServiceImpl.class);

    /**
     * job data key in trigger to track job detail related
     */
    public static final String QUARTZ_JOB_DETAIL_KEY            = "jobDetail";

    /**
     * host, module, keys to get job definition from database
     */
    public static final String HOST                             = "ALL";
    public static final String MODULE                           = "QUARTZ";

    public static final String KEY_4_ACTIVE_JOBS                = "active_jobs";
    public static final String KEY_4_AVAILABLE_JOBS             = "available_jobs";
    public static final String KEY_4_OVERWRITE_EXISTING_JOBS    = "overwrite_existing_jobs";
    public static final String KEY_4_ORDER_SIZE_CALC_JOB        = "order_size_calc_job";

    public static final String DEFAULT_GROUP                    = QuartzServiceImpl.class.getName();
    public static final String YES                              = "Y";

    /**
     * config dao to get job definition
     */
    private NbaResourceConfigDao configDao;

    /**
     * scheduler service
     */
    private SchedulerService schedulerService;

    //// getters & settings
    public void setSchedulerService(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    public SchedulerService getSchedulerService() {
        return this.schedulerService;
    }

    public void setConfigDao(NbaResourceConfigDao configDao) {
        this.configDao = configDao;
    }

    @Override
    public void scheduleJobs() {
        Scheduler scheduler = this.schedulerService.getScheduler();
        if (scheduler == null) {
            throw new SchedulingException("scheduler required to schedule jobs");
        }

        // load overwrite setting from database
        this.schedulerService.setOverwriteExistingJobs(isOverwriteExistingJobs());

        // load all available jobs
        Map<String, JsonJobDefinition> allJobs = getAvailableJobs();

        // load all active jobs
        Set<String> activeJobs = getActiveJobs();

        // special requirement to support calc job [daily, weekly, monthly]
        // job detail should be present in available jobs setting
        String calcJobName = this.getOrderSizeCalculationJobName();
        if (calcJobName != null) {
            activeJobs.add(calcJobName);
        }

        if (allJobs != null && !allJobs.isEmpty()
                && activeJobs != null && !activeJobs.isEmpty()) {

                for (String key : activeJobs) {
                    if (allJobs.containsKey(key)) {
                        JsonJobDefinition job = allJobs.get(key);

                        scheduleJob(job);
                    }
                }

        } else {
            LOGGER.error("no jobs found");
        }
    }

    private boolean scheduleJob(JsonJobDefinition job) {
        try {
            LOGGER.info(String.format(
                    "schedule job => key: %s;job name: %s; trigger name: %s; trigger exp:%s; job class: %s",
                    job.getKey(),
                    job.getJobName(),
                    job.getTriggerName(),
                    job.getTriggerExpression(),
                    job.getJobClass()
            ));

            Class jobClazz = fromClazzName(job.getJobClass());

            if (jobClazz == null ) {
                return false;
            }
            JobDetail jd = new JobDetail(job.getJobName(), DEFAULT_GROUP, jobClazz);
            CronTrigger ct = new CronTrigger(job.getTriggerName(), DEFAULT_GROUP, job.getTriggerExpression());
            ct.setJobName(jd.getName());
            ct.setJobGroup(jd.getGroup());

            // schedule job
            this.schedulerService.schedule(jd, ct);

            LOGGER.info("schedule job => done");
            return true;
        } catch (ParseException pe) {
            LOGGER.error("invalid cron expression", pe);
        } catch (SchedulerException se) {
            LOGGER.error("failed to schedule jobs", se);
        }

        LOGGER.error("schedule job => failed");
        return false;
    }

    /**
     * load job class by name, exception raise if not found and not implement interface {@link org.quartz.Job Quartz Job}
     * @param name full qualified class name
     * @return Clazz from given name
     */
    private Class<?> fromClazzName(String name) {
        try {
            Class clazz = Class.forName(name);

            if (!Job.class.isAssignableFrom(clazz)) {
                throw new SchedulingException("interface org.quartz.Job should be implemented by the class " + name);
            }

            return clazz;
        } catch (ClassNotFoundException e) {
            LOGGER.error(String.format("load class failed :: class %s", name), e);
        }

        return null;
    }

    private Map<String, JsonJobDefinition> getAvailableJobs() {
        NbaResourceConfig available = configDao.queryResourceConfigByKey(HOST, MODULE, KEY_4_AVAILABLE_JOBS);
        if (available != null && StringUtils.isNotBlank(available.getValue())) {

            Gson gson = new Gson();
            try {
                return gson.fromJson(available.getValue(),
                        new TypeToken<Map<String, JsonJobDefinition>>() {
                        }.getType()
                );

            } catch (JsonSyntaxException e) {
                LOGGER.error("could not parse json of available jobs", e);
                throw new SchedulingException(String.format("invalid available job json found: [%s]", available.getValue()), e);
            }
        }

        return null;
    }

    private String getOrderSizeCalculationJobName() {
        NbaResourceConfig config = configDao.queryResourceConfigByKey(HOST, MODULE, KEY_4_ORDER_SIZE_CALC_JOB);
        if (config != null) {
            String jobName = config.getValue();
            if (jobName != null && StringUtils.isNotBlank(jobName)) {
                return jobName.trim();
            }
        }

        return null;
    }

    private Set<String> getActiveJobs() {
        Set<String> jobs = new HashSet<String>();
        NbaResourceConfig available = configDao.queryResourceConfigByKey(HOST, MODULE, KEY_4_ACTIVE_JOBS);
        if (available != null && StringUtils.isNotBlank(available.getValue())) {

            Gson gson = new Gson();
            try {
                String[] activeJobs = gson.fromJson(available.getValue(), String[].class);
                jobs.addAll(Arrays.asList(activeJobs));
            } catch (JsonSyntaxException e) {
                LOGGER.error(String.format("invalid active jobs json found: [%s]", available.getValue()), e);
            }
        }
        return jobs;
    }

    private boolean isOverwriteExistingJobs() {
        NbaResourceConfig available = configDao.queryResourceConfigByKey(HOST, MODULE, KEY_4_OVERWRITE_EXISTING_JOBS);
        if (available != null
                && StringUtils.isNotBlank(available.getValue())
                && YES.equalsIgnoreCase(available.getValue().trim())) {
        	return true;
        }

        return false;
    }

}

