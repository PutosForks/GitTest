package com.example.mfe.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Service;

@Service
public class BatchTasklet implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution var1, ChunkContext var2) throws Exception {
        return RepeatStatus.FINISHED;
    }
}
