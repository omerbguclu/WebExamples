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
}
