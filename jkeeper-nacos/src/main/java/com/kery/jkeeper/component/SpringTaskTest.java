package com.kery.jkeeper.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Kery
 * @Description:
 * @date 2023/9/25
 */
@Slf4j
@Component
public class SpringTaskTest {

    @Scheduled(cron = "0/5 * * * * ?")
    private void springTaskStart(){
        log.info("SpringTask定时任务已执行");
    }
}
