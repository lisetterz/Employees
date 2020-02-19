package com.kenzan.employees;

import com.kenzan.employees.models.Employees;
import com.kenzan.employees.repositories.EmployeesRepository;
import com.kenzan.employees.security.JWTAuthorizationFilter;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
public class EmployeesApplication implements CommandLineRunner {
	@Autowired
	private EmployeesRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(EmployeesApplication.class, args);


	}
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// Saving Employees
		repository.save(new Employees((ObjectId.get()),
				"Lisette",
				"M",
				"Ramirez",
				"09051994",
				 "02142020",
				"ACTIVE"));

		repository.save(new Employees((ObjectId.get()),
				"Vanessa",
				"M",
				"Gonzales",
				"10061993",
				"02172020",
				"ACTIVE"));
	}

	/*
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
					.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests()
					.antMatchers(HttpMethod.DELETE, "/").permitAll()
					.anyRequest().authenticated();
		}
	}*/
}

