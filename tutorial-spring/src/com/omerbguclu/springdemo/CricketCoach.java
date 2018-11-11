package com.omerbguclu.springdemo;

public class CricketCoach implements Coach {
	
	private String emailAddress	;
	private String team;
	private FortuneService fortuneService;

	
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constructor");
	}

	@Override
	public String getDailyWorkout() {		
		return "Cricket Coach says "+"Trained bowl for 30 minutes";
	}

	@Override
	public String getDailyFortune() {		
		return "Cricket Coach says "+fortuneService.getFortune();
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}

	public String getEmailAddress() {
		return "Cricket Coach says my email address is "+emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: inside setter method - setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return "Cricket Coach says my team is "+team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: inside setter method - setTeam");
		this.team = team;
	}
	
	

}
