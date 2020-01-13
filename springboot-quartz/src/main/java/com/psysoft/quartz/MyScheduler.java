package com.psysoft.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

public class MyScheduler {


    public static void main(String[] args) throws SchedulerException, InterruptedException {
        // 1、创建调度器Scheduler
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        // 2、创建JobDetail实例，并与PrintWordsJob类绑定(Job执行内容)
        JobDetail jobDetail = JobBuilder.newJob(PrintWordsJob.class)
                .withIdentity("job1","group1")
                .build();
        // 3、构建Trigger实例,每隔1s执行一次
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("tigger1","tiggerGroup1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(5) // 五秒循环
                .repeatForever())  // 一直
                .build();

        //4、执行

        scheduler.scheduleJob(jobDetail,trigger);
        System.out.println("执行schduler");
        scheduler.start();


        // 睡眠
        TimeUnit.MINUTES.sleep(1);
        scheduler.shutdown();
        System.out.println("结束行schduler");


    }
}
