package com.app.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author brajesh
 *
 *Application centralized logger
 */
@Aspect
@Component
public class ApplicationLogger {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationLogger.class);
	@Pointcut("execution(* com.app.*.*.*(..))") 
	public void loggingPointcut() {
	}
	
	/**
	 * @param pjp
	 * log into console
	 * @throws Throwable
	 */
	@Around("loggingPointcut()")
	public Object ApplicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().toString();
		Object[] array = pjp.getArgs();
		LOGGER.info("method invoked:" + methodName + "()  className:" + className + "   Request:"
				+ mapper.writeValueAsString(array)); 
		Object object = pjp.proceed();
		LOGGER.info(methodName + " className " + className + "  Response:" + mapper.writeValueAsString(object));
		return object;
	}
}
