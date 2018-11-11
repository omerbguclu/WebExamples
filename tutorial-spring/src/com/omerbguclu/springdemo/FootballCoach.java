package com.omerbguclu.springdemo;

public class FootballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public FootballCoach() {
		System.out.println("FootballCoach: inside no-arg constructor");
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("FootballCoach: inside the setter method->setFortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {		
		return "Trained tackling and goaling";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
