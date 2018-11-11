package com.omerbguclu.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private String[] fortune = { "Today is your lucky day.", "Today is your neutral day.",
			"Today is your bad day. Sorry!" };
	
	private Random random = new Random();

	@Override
	public String getFortune() {
		int luck = random.nextInt(fortune.length);
		return fortune[luck];
	}

}
