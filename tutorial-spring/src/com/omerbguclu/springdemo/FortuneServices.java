package com.omerbguclu.springdemo;

import java.util.Random;

public class FortuneServices implements FortuneService {
	private String [] fortune = {
			"Today is your lucky day. You'll have a little extra luck.",
			"Today is your neutral day. The day is in your hands.",
			"Today is your unlucky day. Luck will not be on your side."
	};
	
	private Random random = new Random();
	
	@Override
	public String getFortune() {
		int  luck = random.nextInt(fortune.length);		
		return fortune[luck];
	}

}
