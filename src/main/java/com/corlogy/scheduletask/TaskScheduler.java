package com.corlogy.scheduletask;

import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class TaskScheduler {

//	@Scheduled(fixedDelay = 1000)
//	public void scheduleTaskUsingFixedDelay() throws InterruptedException {
//		System.out.println("Task1 - " + new Date());
//	}
//
//	@Scheduled(fixedRate = 5000)
//	public void scheduleTaskUsingFixedRate() throws InterruptedException {
//		System.out.println("Task2 - " + new Date());
//	}

	@Scheduled(cron = "0 51 8 * * ?")
	public void scheduleTaskUsingCronExpression() throws InterruptedException {
		System.out.println("Task3 - " + new Date());
	}
}
