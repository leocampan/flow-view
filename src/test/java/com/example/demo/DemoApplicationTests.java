package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.repositories.EmployeeRepo;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	EmployeeRepo employeeRepo; 
	@Test
	void contextLoads() {

		employeeRepo.deleteById(587191L);
	}

}
