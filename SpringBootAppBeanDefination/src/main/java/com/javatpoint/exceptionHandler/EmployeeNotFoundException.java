package com.javatpoint.exceptionHandler;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3945836215629510153L;

	public EmployeeNotFoundException(String message) {
		super(message);
	}

}
