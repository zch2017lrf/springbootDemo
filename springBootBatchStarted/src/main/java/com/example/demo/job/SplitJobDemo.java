package com.example.demo.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.stereotype.Component;

/**
 * 任务中的步骤除了可以串行执行（一个接着一个执行）外，
 * 还可以并行执行，
 * 并行执行在特定的业务需求下可以提供任务执行效率。
 */
@Component
public class SplitJobDemo {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    /**
     * 将步骤Step转换为Flow；
     * 任务Job中指定并行Flow。
     * @return
     */
    @Bean
    public Job splitJob() {
        return jobBuilderFactory.get("splitJob1")
                .start(flow1())
                .split(new SimpleAsyncTaskExecutor()).add(flow2())
                .end()
                .build();

    }

    /**
     * 可以看到step3并没有在step2后才执行，
     * 说明步骤已经是并行化的
     * （开启并行化后，并行的步骤执行顺序并不能100%确定
     * ，因为线程调度具有不确定性）
     * @return
     */
    private Step step1() {
        return stepBuilderFactory.get("step1")
                .tasklet((stepContribution, chunkContext) -> {
                    System.out.println("执行步骤一操作。。。");
                    return RepeatStatus.FINISHED;
                }).build();
    }

    private Step step2() {
        return stepBuilderFactory.get("step2")
                .tasklet((stepContribution, chunkContext) -> {
                    System.out.println("执行步骤二操作。。。");
                    return RepeatStatus.FINISHED;
                }).build();
    }

    private Step step3() {
        return stepBuilderFactory.get("step3")
                .tasklet((stepContribution, chunkContext) -> {
                    System.out.println("执行步骤三操作。。。");
                    return RepeatStatus.FINISHED;
                }).build();
    }

    private Flow flow1() {
        return new FlowBuilder<Flow>("flow1")
                .start(step1())
                .next(step2())
                .build();
    }

    private Flow flow2() {
        return new FlowBuilder<Flow>("flow2")
                .start(step3())
                .build();
    }
}
