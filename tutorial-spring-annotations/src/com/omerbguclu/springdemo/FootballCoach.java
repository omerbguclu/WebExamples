package com.omerbguclu.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

	private List<String> fortune;
	private File file;
	private Random random = new Random();

	@Override
	public String getDailyWorkout() {
		return "Football coach says -> We practised goaling and playmaking.";
	}

	@Override
	public String getDailyFortune() {
		int luck = random.nextInt(fortune.size());
		return "Football coach says -> "+fortune.get(luck);
	}

	@PostConstruct
	public void myInitMethod() {
		System.out.println("Football: start of myInitMethod-----------------------------------------");
		file = new File("Fortunes.txt");
		fortune = new ArrayList<String>();
		String template;
		try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {

			while ((template = buffer.readLine()) != null) {
				//System.out.println("Item added-> "+template);
				fortune.add(template);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Football: finish of myInitMethod-----------------------------------------");
	}

	@PreDestroy
	public void myDestroyMethod() {
		System.out.println("Football: inside of myDestroyMethod");
	}

}
