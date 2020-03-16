package com.example.demo.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 重新启动项目，控制台并不会再次打印出任务执行日志，
 * 因为Job名称和 Step名称组成唯一，执行完的不可重复的任务，
 * 不会再次执行。
 */
@Component
public class FirstJobDemo {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job firstJob() {
        return jobBuilderFactory.get("firstJob")
                .start(step())
                .build();
    }

    private Step step() {
        return stepBuilderFactory.get("step")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("执行步骤....");
                    //返回表示小任务完成
                    return RepeatStatus.FINISHED;
                }).build();
    }
}
