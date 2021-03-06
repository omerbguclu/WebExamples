package com.omerbguclu.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@SuppressWarnings("deprecation")
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// add our users for in memory authentication
	
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
		.withUser(users.username("john").password("t123").roles("EMPLOYEE"))
		.withUser(users.username("mary").password("t123").roles("MANAGER"))
		.withUser(users.username("susan").password("t123").roles("ADMIN"));
	}

		
}
