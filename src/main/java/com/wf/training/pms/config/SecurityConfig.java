package com.wf.training.pms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		@SuppressWarnings("deprecation")
		UserBuilder builder = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication().withUser(builder.username("admin").password("admin").roles("User"));
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.authorizeRequests().and().formLogin().loginPage("/index").permitAll().and().logout()
				.logoutSuccessUrl("/logout").permitAll().and().exceptionHandling() 
				.accessDeniedPage("/access-denied"); 
	}
}
