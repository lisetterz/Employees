package com.kenzan.employees;

import com.kenzan.employees.models.Employees;
import com.kenzan.employees.repositories.EmployeesRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeesApplication implements CommandLineRunner {
	@Autowired
	private EmployeesRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(EmployeesApplication.class, args);


	}
	@Override
	public void run(String... args) throws Exception {

		//repository.deleteAll();

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

}

