package com.akeb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.inMemoryAuthentication()
		.passwordEncoder(getPasswordEncoder())
		.withUser("admin").password(getPasswordEncoder().encode("akeb#83EN")).authorities("ADMIN")
		.and()
		.withUser("user1").password(getPasswordEncoder().encode("akeb#83DE")).authorities("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.authorizeRequests()
		.antMatchers("/webinars").permitAll()
		.antMatchers(HttpMethod.GET, "/webinar/**").permitAll()
		.antMatchers(HttpMethod.POST, "/webinar/**").authenticated()
		.antMatchers("/user/webinar/register").permitAll()
		.antMatchers("/user/webinar/questions/**/**").permitAll()
		 
		
		.and()
		.httpBasic();
		
		
		http.cors();
		http.csrf().disable();
		 
}
	@Primary
	@Bean
	public PasswordEncoder getPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}	
}
