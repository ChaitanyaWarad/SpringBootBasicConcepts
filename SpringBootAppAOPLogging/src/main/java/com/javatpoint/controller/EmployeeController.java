package com.javatpoint.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.model.Employee;
import com.javatpoint.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/test")
	public String test() {
		return "Application is working fine !!!";
	}

	@RequestMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		List<Employee> emp = employeeService.getAllEmployees();
		return emp;
	}

	@RequestMapping("/getEmployeeById/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable int id) {
		Optional<Employee> emp = employeeService.getEmployeeById(id);
		return emp;
	}

	@PostMapping("/insertEmployee")
	public String insertEmployee(@RequestBody Employee emp) {
		employeeService.insertEmployee(emp);
		return "Employee Added";
	}

	@DeleteMapping("/deleteEmployeeById/{id}")
	public String deleteEmployeeById(@PathVariable int id) {
		employeeService.deleteEmployeeById(id);
		return "Employee Deleted";
	}

	@PutMapping("/updateEmployee")
	public String updateEmployee(@RequestBody Employee emp) {
		employeeService.updateEmployeeById(emp);
		return "Employee Updated";
	}

}
