package com.brionesclavijo.mascota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired //Authetication
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception
	{	
		BCryptPasswordEncoder encoder = passwordEncoder();
		
		UserBuilder users = User.builder().passwordEncoder(password->{
			return encoder.encode(password);
		});
		
		build.inMemoryAuthentication()
		.withUser(users.username("admin").password("1234").roles("ADMIN", "USER"))
		.withUser(users.username("user").password("1234").roles("USER"));
	}

}
