package com.huhupa.base.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 定时任务
 */
@Component
public class TimerTasks {

    //    @Scheduled(fixedDelay = 10000) // 10 秒执行一次
    @Scheduled(cron="0 0 3 ? * *") // 凌晨3点执行一次
    public void test1(){
        System.out.println("凌晨3点执行一次：" + System.currentTimeMillis());
    }

    @Scheduled(cron="0 53 14 ? * *") // 下午14点53分执行一次
//    @Scheduled(fixedDelay = 10000)
    public void test2(){
        System.out.println("下午14点53分执行一次：" + new Date());
    }
}
