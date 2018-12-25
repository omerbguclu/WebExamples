package com.omerbguclu.springboot.demo.tutorialspringboot01.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	// expose "/" that return hello world
	@GetMapping("/")
	public String sayHello() {
		return "Hello world! Time on server is " + LocalDateTime.now();
	}
	
	// expose a new end point for "work-out"
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}
	
	// expose a new end point for "fortune"
	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "Today is your lucky day.";
	}
}
