package com.psysoft.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class PrintWordsJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // JobExecutionContext包含了Quartz运行时的环境以及Job本身的详细数据信息
        String printTime = new SimpleDateFormat("yy-MM-dd HH-mm-ss").format(Calendar.getInstance().getTime());
        System.out.println("PrintWordsJob start at:" + printTime + ", prints: Hello Job-" + new Random().nextInt(100));
    }
}
