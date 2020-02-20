package com.kenzan.employees.controller;

import com.kenzan.employees.models.Employees;
import com.kenzan.employees.repositories.EmployeesRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    @Autowired
    private EmployeesRepository repository;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Employees> getAllEmployees() {
        return (List<Employees>) repository.findAll();

    }
    @RequestMapping(value = "/getAllActive", method = RequestMethod.GET)
    public List<Employees> getAllActiveEmployees() {
        return (List<Employees>) repository.findAllActiveEmployees();

    }

    @RequestMapping(value = "/getByName/{name}", method = RequestMethod.GET)
    public List<Employees> findByName(@PathVariable("name") String name) {
        return repository.findByFirstName(name);
    }


    @RequestMapping(value = "/getByID/{id}", method = RequestMethod.GET)
    public Employees getEmployeeById(@PathVariable("id") ObjectId id) {
        return repository.findByID(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Employees createEmployee(@Valid @RequestBody Employees employees) {
        employees.setId(ObjectId.get());
        repository.insert(employees);
        return employees;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public Employees modifyEmployeeById(@PathVariable("id") ObjectId ID, @Valid @RequestBody Employees employees){
        employees.setId(ID);
        repository.save(employees);
        return employees;
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable("id") ObjectId id) {
        Employees employees = new Employees();
        employees = repository.findByID(id);
        employees.setStatus("INACTIVE");
        repository.save(employees);
    }

    @RequestMapping(value = "deleteAll", method = RequestMethod.DELETE)
    public void deleteAll() {
       repository.deleteAll();
    }
}
