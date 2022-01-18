package com.javatpoint.ascept;

import org.aopalliance.intercept.Joinpoint;
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAscept {

	private static Logger logger = Logger.getLogger(LoggerAscept.class);

	@Pointcut("execution(* com.javatpoint.*.*.*(..))")
	private void generalPointCut() {

	}

	@Before("generalPointCut()")
	public void infoLog(Joinpoint joinpoint) {
		logger.info(joinpoint.getClass().getSimpleName() + " : " + joinpoint.getClass().getSimpleName());
	}

}
