package com.kenzan.employees;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.io.File;
import java.util.List;

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

		//create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();

		//read json file and convert to customer object

		ObjectMapper mapper = new ObjectMapper();
		List<Employees> employees = mapper.reader()
				.forType(new TypeReference<List<Employees>>() {})
				.readValue(new File("src/main/resources/employeesRecords.json"));

		repository.saveAll(employees);
	}
}

