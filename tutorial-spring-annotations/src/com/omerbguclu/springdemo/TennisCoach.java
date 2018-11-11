package com.omerbguclu.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("fileFortuneService")
	private FortuneService fortuneService;

	// define a default constructor
	public TennisCoach() {
		System.out.println("TennisCoach: inside default constructor");
	}

	// define a setter method
/*	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("TennisCoach: inside method setFortuneService");
		this.fortuneService = fortuneService;
	}*/

/*	@Autowired
	public void doSomeCrazyStuff(FortuneService fortuneService) {
		System.out.println("TennisCoach: inside method doSomeCrazyStuff");
		this.fortuneService = fortuneService;
	}*/

	/*
	  @Autowired
	  public TennisCoach(FortuneService fortuneService) {
	  	this.fortuneService = fortuneService; }
	 */

	@Override
	public String getDailyWorkout() {
		return "Tennis coach says -> Practise your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return "Tennis coach says -> " + fortuneService.getFortune();
	}

}
