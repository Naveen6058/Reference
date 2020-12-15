package com.wf.training.bootapprestfulcrud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

// WebSecurityConfigurerAdapter : class provides methods to add config

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	// 3 configuration method
	
	// define the credentials
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// in memory auth : fixed hard coded credential
		// database 
		// ldap based 
		
		//  create user (in-memory auth)
		UserBuilder builder = User.withDefaultPasswordEncoder(); 
		auth.inMemoryAuthentication()
//			.withUser(builder.username("1").password("abc").roles("User"))
//			.withUser(builder.username("002").password("abc").roles("SuperUser"))
//			.withUser(builder.username("003").password("abc").roles("bouser"));
		.withUser(builder.username("admin").password("admin").roles("User"));
		
	}
	
	// define the rules to access
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// auto maintains session for user
		http.authorizeRequests() // start defining auth rule
//			.antMatchers("/user/**").hasRole("User")
//			//.antMatchers("/superuser/**").hasRole("SuperUser")
//			//.antMatchers("/bouser/**").hasRole("bouser")
//			.anyRequest() // all are secured
//			.authenticated()
		.and()
//			.httpBasic()
			.formLogin()  // auth type is form based login 
			.loginPage("/index") // url of custom login page (handler method)
//			.loginProcessingUrl("/validate") // inbuilt handler (free of cost)
			.permitAll() // allow everyone to access login
		.and()
	.logout().logoutSuccessUrl("/logout").permitAll()
		.and()
			.exceptionHandling() // security exception
				.accessDeniedPage("/access-denied"); // url of custom access denied (handler)
	}
}
