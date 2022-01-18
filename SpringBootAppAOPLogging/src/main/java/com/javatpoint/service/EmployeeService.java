package com.javatpoint.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatpoint.model.Employee;
import com.javatpoint.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;

	public List<Employee> getAllEmployees() {
		List<Employee> emp = (List<Employee>) employeeRepo.findAll();
		return emp;
	}

	public Optional<Employee> getEmployeeById(int id) {
		Optional<Employee> emp = employeeRepo.findById(id);
		return emp;
	}

	public void insertEmployee(Employee emp) {
		employeeRepo.save(emp);
	}

	public void deleteEmployeeById(int id) {
		employeeRepo.deleteById(id);
	}

	public void updateEmployeeById(Employee emp) {
		employeeRepo.save(emp);
	}

}
