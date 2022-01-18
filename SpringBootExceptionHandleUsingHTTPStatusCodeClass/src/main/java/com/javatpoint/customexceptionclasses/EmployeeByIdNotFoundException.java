package com.javatpoint.customexceptionclasses;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No Employee Found By Id")
public class EmployeeByIdNotFoundException extends RuntimeException {

}
