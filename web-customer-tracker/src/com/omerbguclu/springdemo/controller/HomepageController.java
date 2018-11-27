package com.omerbguclu.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomepageController {

	@RequestMapping("/home")
	public String homepage() {
		return "homepage";
	}
}