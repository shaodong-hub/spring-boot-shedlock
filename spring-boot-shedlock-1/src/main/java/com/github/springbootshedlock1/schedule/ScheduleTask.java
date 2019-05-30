package com.github.springbootshedlock1.schedule;

import net.javacrumbs.shedlock.core.SchedulerLock;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * defaultLockAtMostFor 指定在执行节点结束时应保留锁的默认时间使用ISO8601 Duration格式
 * 作用就是在被加锁的节点挂了时，无法释放锁，造成其他节点无法进行下一任务
 * 这里默认30s
 *
 *
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


    /**
     * lockAtLeastFor：保证在设置的期间类不执行多次任务，单位是毫秒，此处可以根据实际任务运行情况进行设置，
     * 简单来说，一个每15分钟执行的任务，若每次任务执行的时间为几分钟，则可以设置lockAtLeastFor大于其最大估计最大执行时间
     * 避免一次任务未执行完，下一个定时任务又启动了。
     * 任务执行完，会自动释放锁。
     */
    @Scheduled(fixedDelay = 1000)
    @SchedulerLock(name = "scheduledTaskName", lockAtMostFor = 1000, lockAtLeastFor = 1000)
    public void task() {
        System.out.println("spring-boot-shedlock-1:" + new Date());
    }

}
