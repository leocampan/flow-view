package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.demo.domains.Employee;
import com.example.demo.repositories.EmployeeRepo;

@Service
public class EmployeeService {

    EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public List<Employee> findAll() {
        return this.employeeRepo.findAll();
    }

    public Optional<Employee> findById(Long id) {
        Optional<Employee> opt = this.employeeRepo.findById(id);
        return opt;
    }

    public Optional<Employee> save(Employee entity) {
        Employee employee = this.employeeRepo.save(entity);
        Optional<Employee> opt = Optional.ofNullable(employee);
        return opt;
    }

    public Optional<Employee> update(Employee entity) {
        Employee employee = this.employeeRepo.save(entity);
        Optional<Employee> opt = Optional.ofNullable(employee);
        return opt;
    }

    public Optional<Employee> delete(Long id) {
        Optional<Employee> opt = this.employeeRepo.findById(id);
        if (opt.isPresent()) {
            this.employeeRepo.deleteById(id);
        }
        return opt;
    }
}
