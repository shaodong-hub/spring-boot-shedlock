package com.github.springbootshedlock2.schedule;

import net.javacrumbs.shedlock.core.SchedulerLock;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <p>
 * 创建时间为 17:44 2019-05-29
 * 项目名称 spring-boot-shedlock
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Component
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "PT2S")
public class ScheduleTask {

    private static final String FOURTEEN_MIN = "PT1S";

    @Scheduled(fixedDelay = 1000)
//    @SchedulerLock(name = "scheduledTaskName", lockAtMostForString = FOURTEEN_MIN, lockAtLeastForString = FOURTEEN_MIN)
    @SchedulerLock(name = "scheduledTaskName", lockAtMostFor = 1000, lockAtLeastFor = 1000)
    public void task() {
        System.out.println("spring-boot-shedlock-2:" + new Date());
    }

}
