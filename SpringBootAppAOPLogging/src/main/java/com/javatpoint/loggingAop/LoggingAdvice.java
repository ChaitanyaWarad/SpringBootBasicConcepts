package com.javatpoint.loggingAop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggingAdvice {

	Logger logger = LoggerFactory.getLogger(LoggingAdvice.class);

	@Pointcut(value = "execution(* com.javatpoint.*.*.*(..) )")
	public void myPointCut() {

	}

	@Around("myPointCut()")
	public Object applicationLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		ObjectMapper objectMapper = new ObjectMapper();
		String methodName = proceedingJoinPoint.getSignature().getName();
		String className = proceedingJoinPoint.getTarget().getClass().toString();
		Object[] args = proceedingJoinPoint.getArgs();
		logger.info(" " + methodName + " " + className + " " + objectMapper.writeValueAsString(args));
		Object object = proceedingJoinPoint.proceed();
		logger.info(" " + methodName + " " + className + " " + objectMapper.writeValueAsString(object));
		return object;
	}

}
