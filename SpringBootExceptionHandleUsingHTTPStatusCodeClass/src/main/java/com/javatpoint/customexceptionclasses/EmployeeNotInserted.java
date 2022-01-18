package com.javatpoint.customexceptionclasses;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "Employee Not inserted")
public class EmployeeNotInserted extends RuntimeException {

}
