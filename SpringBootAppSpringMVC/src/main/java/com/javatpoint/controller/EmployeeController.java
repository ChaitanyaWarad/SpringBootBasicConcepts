package com.javatpoint.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javatpoint.model.Employee;
import com.javatpoint.service.EmployeeService;


@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/homepage")
	public String homePage(Model model) {
		model.addAttribute("message", "Welcome to homepage");
		return "home";
	}

	@RequestMapping("/addemployee")
	public String insertEmployee(Model model) {
		Employee emp = new Employee();
		model.addAttribute("message", emp);
		return "addemployee";
	}

	@RequestMapping(value = "/addEmployeeInDB", method = RequestMethod.POST)
	public String addEmployeeInDB(@ModelAttribute("emp") Employee emp, Model myModel) {
		boolean b = employeeService.addEmployee(emp);
		if (b) {
			myModel.addAttribute("message", "Employee Inserted");
			return "success";
		} else {
			myModel.addAttribute("message", "Employee Not Inserted");
			return "fail";
		}
	}

	@RequestMapping("/getALlEmployees")
	public String getALlEmployeesInDB(Model myModel) {
		List<Employee> empList = employeeService.getALlEmployeesInDB();
		myModel.addAttribute("empList", empList);
		return "GetAllEmployees";
	}

	@RequestMapping("/updateemployee")
	public String updateemployee(Model myModel, HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		Employee emp = employeeService.getEmployee(id);
		myModel.addAttribute("updateemp", emp);
		return "updateemployee";
	}
	
	@RequestMapping(value = "/updateEmployeeInDB")
	public String updateEmployeeInDB(@ModelAttribute("updateemp") Employee emp, Model myModel) {
		boolean b = employeeService.updateEmployeeInDB(emp);
		if (b) {
			myModel.addAttribute("message", "Employee Updated");
			return "success";
		} else {
			myModel.addAttribute("message", "Employee Not Updated");
			return "fail";
		}
	}
	
	@RequestMapping("/deleteEmployee")
	public String deleteemployee(Model myModel, HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		Employee emp = employeeService.getEmployee(id);
		boolean b = employeeService.deleteEmployeeInDB(emp);
		if (b) {
			myModel.addAttribute("message", "Employee deleted");
			return "success";
		} else {
			myModel.addAttribute("message", "Employee Not deleted");
			return "fail";
		}
	}
}
