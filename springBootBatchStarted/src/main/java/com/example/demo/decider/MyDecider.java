package com.example.demo.decider;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * 任务决策器
 * 决策器的作用就是可以指定程序在不同的情况下运行不同的任务流程，比如今天是周末，则让任务执行step1和step2，如果是工作日，则之心step1和step3
 */
@Component
public class MyDecider implements JobExecutionDecider {

  @Override
    public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
        LocalDate now = LocalDate.now();
        DayOfWeek dayOfWeek = now.getDayOfWeek();

        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            return new FlowExecutionStatus("weekend");
        } else {
            return new FlowExecutionStatus("workingDay");
        }
    }
}
