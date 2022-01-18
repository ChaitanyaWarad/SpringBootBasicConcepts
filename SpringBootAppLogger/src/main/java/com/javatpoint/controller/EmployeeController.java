package com.javatpoint.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.model.Employee;
import com.javatpoint.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {

	Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeServiceImpl EmployeeServiceImpl;

	@RequestMapping("/test")
	public String test() {
		return "Hello World !!!";
	}

	@RequestMapping("/logInfo")
	public String loggerInfo() {
		logger.trace("A TRACE Message");
		logger.debug("A DEBUG Message");
		logger.info("An INFO Message");
		logger.warn("A WARN Message");
		logger.error("An ERROR Message");
		return "Working fine!!! ";
	}

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		List<Employee> emp = EmployeeServiceImpl.getAllEmployees();
		return emp;
	}

	@GetMapping("/getEmployeeById/{empid}")
	public Optional<Employee> getEmployeeById(@PathVariable("empid") int empid) {
		Optional<Employee> emp = EmployeeServiceImpl.getEmployeeById(empid);
		return emp;
	}

	@PostMapping("/insertEmployeeInDb")
	public String insertEmployeeInDb(@RequestBody Employee emp) {
		EmployeeServiceImpl.insertEmployeeInDb(emp);
		return "Employee is inserted";

	}

}
