package com.kenzan.employees.repositories;

import com.kenzan.employees.models.Employees;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EmployeesRepository extends MongoRepository<Employees, String> {
    @Query("{'id': ?0, 'status': 'ACTIVE'}")
    Employees findByID(ObjectId id);

    @Query("{ 'status' : 'ACTIVE' }")
    List<Employees> findAllActiveEmployees();

    @Query("{ 'firstName' : ?0, 'status' : 'ACTIVE' }")
    List<Employees> findByFirstName(String firstName);

}
