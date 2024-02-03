package com.app.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.listener.MyJobListener;
import com.app.processor.DataProcessor;
import com.app.reader.DataReader;
import com.app.writer.DataWriter;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job jobA() {
		return jobBuilderFactory.get("jobA")
				.incrementer(new RunIdIncrementer())
				.listener(listener())
				.start(stepA())
				.build();
	}
	@Bean
	public Step stepA() {
		return stepBuilderFactory.get("stepA")
				.<String,String>chunk(1)
				.reader(new DataReader())
				.processor(new DataProcessor())
				.writer(new DataWriter())
				.build();
	}
	@Bean
	public JobExecutionListener listener() {
		return new MyJobListener();
	}

}
