package com.javatpoint.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatpoint.model.Employee;
import com.javatpoint.repositories.EmployeeRepo;

@Service
public class EmployeeServiceImpl {

	@Autowired
	EmployeeRepo employeeRepo;

	public List<Employee> getAllEmployees() {
		List<Employee> emp = (List<Employee>) employeeRepo.findAll();
		return emp;
	}

	public void insertEmployeeInDb(Employee emp) {
		Employee b = employeeRepo.save(emp);

	}

	public Optional<Employee> getEmployeeById(int empid) {
		Optional<Employee> emp = Optional.of(employeeRepo.findById(empid).get());
		return emp;
	}

	public void deleteEmployeeById(int empid) {
		employeeRepo.deleteById(empid);

	}

	public void updateEmployeeInDB(Employee emp) {
		employeeRepo.save(emp);

	}

}
