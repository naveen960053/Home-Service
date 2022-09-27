package com.cts.homeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		System.out.println("configure2");
		http.authorizeRequests()
			.antMatchers("/user/**").permitAll()
			.antMatchers("/").hasAnyAuthority("USER","ADMIN","VENDOR")
			.antMatchers("/user/login").permitAll()
			.antMatchers("/user/register").permitAll()
			.antMatchers("/admin/login").permitAll()
			.antMatchers("/vendor/login").permitAll()
			.antMatchers("/admin/register").permitAll()
			.antMatchers("/vendor/register").permitAll()
			.antMatchers("/admin/hello").hasAuthority("ADMIN")
			.antMatchers("/vendor/role/**").hasAuthority("VENDOR")
			.and()
			.formLogin()
				.loginPage("/user/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.defaultSuccessUrl("/")
				.permitAll()
		        .and()
		        .logout()
		        .permitAll()
		        .and()
		        .exceptionHandling().accessDeniedPage("/user/access-denied");
		
	} 

	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
