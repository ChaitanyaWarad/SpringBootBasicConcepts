package com.javatpoint.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@RequestMapping("/test")
	public String test() {
		return "Working App!!!";
	}

}
