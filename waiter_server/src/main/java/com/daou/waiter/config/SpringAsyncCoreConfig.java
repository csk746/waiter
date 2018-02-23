package com.daou.waiter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by hsim on 2017. 8. 13...
 */
@EnableAsync
@Configuration
@Slf4j
public class SpringAsyncCoreConfig {

    private final int corePoolSize = 5;
    private final int maxPoolSize = 10;
    private final int queueMaxSize = 50;

    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();

        taskExecutor.setCorePoolSize(this.corePoolSize);
        taskExecutor.setMaxPoolSize(this.maxPoolSize);
        taskExecutor.setQueueCapacity(this.queueMaxSize);

        return taskExecutor;
    }

    @Autowired
    private void logging() {
        log.info("---------------------ThreadPoolTaskExecutor Setting-----------------------");
        log.info("ThreadPoolTaskExecutor : corePoolSize : " + this.corePoolSize);
        log.info("ThreadPoolTaskExecutor : maxPoolSize : " + this.maxPoolSize);
        log.info("ThreadPoolTaskExecutor : queueMaxSize : " + this.queueMaxSize);
        log.info("---------------------ThreadPoolTaskExecutor Setting-----------------------\n");
    }

}


