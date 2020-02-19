package com.kenzan.employees.repositories;

import com.kenzan.employees.models.Employees;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EmployeesRepository extends MongoRepository<Employees, String> {
    @Query("{'ID': ?0, 'Status': 'ACTIVE'}")
    Employees findByID(ObjectId ID);

    @Query("{ 'Status' : 'ACTIVE' }")
    List<Employees> findAllActiveEmployees();

    @Query("{ 'FirstName' : ?0, 'Status' : 'ACTIVE' }")
    List<Employees> findByFirstName(String firstName);

  /*
    @Query("{ De")
    updateOne(ObjectId id);

   */
 /* Query query = new Query();
query.addCriteria(Criteria.where("name").is("Eric"));
    List<Employees> employees = mongoTemplate.find(query, Employees.class);*/
}
