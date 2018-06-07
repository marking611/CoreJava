package com.mak;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by makai on 2018/3/26.
 */
@Service
@EnableScheduling
public class TaskA implements SchedulingConfigurer {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:dd");
    public  String cron = "0 0/1 11-23 * * ?";

    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        System.out.println(simpleDateFormat.format(new Date())+"---------------触发了------------");
        taskRegistrar.addTriggerTask(() -> {
            System.out.println(simpleDateFormat.format(new Date())+"-------run-----");
            System.out.println(cron);
        }, triggerContext -> {
            System.out.println(simpleDateFormat.format(new Date())+"--------------进入--------------");
            System.out.println(cron);
            CronTrigger trigger = new CronTrigger(cron);
            Date nextExecDate = trigger.nextExecutionTime(triggerContext);
            return nextExecDate;
        });
    }
}
