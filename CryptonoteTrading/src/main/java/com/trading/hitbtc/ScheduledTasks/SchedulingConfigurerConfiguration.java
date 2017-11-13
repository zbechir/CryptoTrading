package com.trading.hitbtc.ScheduledTasks;

import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

public class SchedulingConfigurerConfiguration implements SchedulingConfigurer {

	@Override
	public void configureTasks(ScheduledTaskRegistrar arg0) {
		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(100);
        taskScheduler.initialize();
        arg0.setTaskScheduler(taskScheduler);

	}

}
