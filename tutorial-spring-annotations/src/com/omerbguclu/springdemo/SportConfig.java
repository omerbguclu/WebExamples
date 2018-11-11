package com.omerbguclu.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.omerbguclu.springdemo")
@PropertySource("info.properties")
public class SportConfig {
	
	//define bean for our sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	//define bean for our swim coach AND inject dependency
	@Bean
	public Coach trackCoach() {
		return new TrackCoach(sadFortuneService());
	}
}
