package com.javatpoint.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javatpoint.controller.EmployeeController;
import com.javatpoint.model.Employee;
import com.javatpoint.repositories.EmployeeRepo;

@Service
public class EmployeeServiceImpl {
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeRepo employeeRepo;

	public List<Employee> getAllEmployees() {
		logger.info("EmployeeServiceImpl - getAllEmployees()");
		List<Employee> emp = (List<Employee>) employeeRepo.findAll();
		return emp;
	}

	public void insertEmployeeInDb(Employee emp) {
		logger.info("EmployeeServiceImpl - insertEmployeeInDb()");
		Employee b = employeeRepo.save(emp);

	}

	public Optional<Employee> getEmployeeById(int empid) {
		logger.info("EmployeeServiceImpl - getEmployeeById()");
		Optional<Employee> emp = employeeRepo.findById(empid);
		return emp;
	}

}
