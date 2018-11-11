package com.omerbguclu.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortune;

	@Value("${foo.email}")
	private String email;

	@Value("${foo.team}")
	private String team;

	@Override
	public String getDailyWorkout() {
		return "Swim Coach says -> We trained 1 hour backswimming.";
	}

	@Override
	public String getDailyFortune() {
		return "Swim Coach says -> " + fortune.getFortune();
	}

	public String getEmail() {
		return "Swim Coach says -> My email address is " + email;
	}

	public String getTeam() {
		return "Swim Coach says -> My team name is " + team;
	}

}
