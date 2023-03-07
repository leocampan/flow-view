package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domains.Employee;
import com.example.demo.services.EmployeeService;

@RestController

@RequestMapping(path = "/api/employees", produces = "application/json")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT }, maxAge = 3600)
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public List<Employee> getEmployees() {
        return this.employeeService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        Optional<Employee> employee = this.employeeService.findById(id);

        if (employee.isPresent())
            return new ResponseEntity<Employee>(employee.get(), HttpStatus.valueOf(302)); // Found
        else
            return new ResponseEntity<Employee>(HttpStatus.valueOf(404)); // Not Found
    }

    @PostMapping("")
    public ResponseEntity<Employee> add(@RequestBody Employee entity) {
        if (this.employeeService.save(entity).isPresent())
            return new ResponseEntity<Employee>(entity, HttpStatus.valueOf(201)); // Created
        else
            return new ResponseEntity<Employee>(HttpStatus.valueOf(400)); // Bad Request
    }

    @PutMapping("")
    public ResponseEntity<Employee> update(@RequestBody Employee entity) {
        if (this.employeeService.save(entity).isPresent())
            return new ResponseEntity<Employee>(entity, HttpStatus.valueOf(201)); // Created
        else
            return new ResponseEntity<Employee>(HttpStatus.valueOf(400)); // Bad Request
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> delete(@PathVariable Long id) {
        if (this.employeeService.delete(id).isPresent())
            return new ResponseEntity<Employee>(HttpStatus.valueOf(200)); // Ok
        else
            return new ResponseEntity<Employee>(HttpStatus.valueOf(404)); // Not Found
    }
}
