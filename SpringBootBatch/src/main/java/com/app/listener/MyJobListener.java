package com.app.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class MyJobListener implements JobExecutionListener {

	@Override
	public void beforeJob(JobExecution jobExecution) {
        System.out.println(jobExecution.getStartTime());
        System.out.println(jobExecution.getStatus());
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println(jobExecution.getEndTime());
		System.out.println(jobExecution.getStatus());

	}

}
