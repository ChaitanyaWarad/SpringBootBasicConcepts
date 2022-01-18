package com.javatpoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
		return "Working fine !!!";
	}

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		List<Employee> emp = employeeService.getAllEmployees();
		return emp;
	}

	@GetMapping("/getEmployeeByid/{empid}")
	public Employee getEmployeeByid(@PathVariable("empid") int empid) {
		Employee emp = employeeService.getEmployeeByid(empid);
		return emp;
	}

	@PostMapping("/insertEmloyeeInDb")
	public String insertEmloyeeInDb(@RequestBody Employee emp) {
		boolean b = employeeService.insertEmloyeeInDb(emp);
		if (b = true) {
			return "employee is inserted";
		} else {
			return "employee is not inserted";
		}
	}

	@DeleteMapping("/deleteEmployeeById/{empid}")
	public String deleteEmployeeById(@PathVariable("empid") int empid) {
		boolean b = employeeService.deleteEmployeeById(empid);
		if (b = true) {
			return "employee deleted";
		} else {
			return "employee is not deleted";
		}
	}

	@PutMapping("/updateEmployee")
	public String updateEmployee(@RequestBody Employee emp) {
		boolean b = employeeService.updateEmployee(emp);
		if (b = true) {
			return "employee updated";
		} else {
			return "employee is not updated";
		}
	}
}
