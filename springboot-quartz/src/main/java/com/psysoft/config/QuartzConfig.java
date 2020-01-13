package com.psysoft.config;

import com.psysoft.job.MyJopTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

//@Configuration
public class QuartzConfig {

    /**
     * 将Job放入JobDetailFactoryBean
     * @return
     */
    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean(){
        JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
        //关联我们定义的Job类
        jobDetailFactory.setJobClass(MyJopTest.class);
        return jobDetailFactory;
    }


    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactory){
        SimpleTriggerFactoryBean simpleTriggerFactory = new SimpleTriggerFactoryBean();
        simpleTriggerFactory.setJobDetail(jobDetailFactory.getObject());
        simpleTriggerFactory.setRepeatInterval(3000);
        simpleTriggerFactory.setRepeatCount(10);
        return  simpleTriggerFactory;
    }

    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean JobDetailFactoryBean){
        CronTriggerFactoryBean cronTriggerFactory = new CronTriggerFactoryBean();
        cronTriggerFactory.setJobDetail(JobDetailFactoryBean.getObject());
        cronTriggerFactory.setCronExpression("0/3 * * * * ?");
        return cronTriggerFactory;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactory){
        SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();
        schedulerFactory.setTriggers(cronTriggerFactory.getObject());
        return schedulerFactory;
    }


    public SchedulerFactoryBean schedulerFactoryBean(SimpleTriggerFactoryBean simpleTriggerFactory){
        SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();
        schedulerFactory.setTriggers(simpleTriggerFactory.getObject());
        return schedulerFactory;
    }
}
