package com.javatpoint.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EmployeeAop {

	@Before("execution(public String test())")
	public void execute(JoinPoint point) {
		System.out.println("executing aspect...");
		System.out.println(point.getSignature().getName());
	}

}
