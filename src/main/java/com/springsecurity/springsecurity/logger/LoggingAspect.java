package com.springsecurity.springsecurity.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	@Before("execution(* com.springsecurity.springsecurity.service.*.*(..))")
	public void logBeforeMethod(JoinPoint joinPoint) {
		logger.info("Executing method: " + joinPoint.getSignature().getName());
	}

	@AfterReturning("execution(* com.springsecurity.springsecurity.service.*.*(..))")
	public void logAfterMethod(JoinPoint joinPoint) {
		logger.info("Method executed: " + joinPoint.getSignature().getName());
	}
}
