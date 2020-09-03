package com.ezypay.util.logs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *  This class is use to handle log in payment service
 *  There are methods for all log levels.
 *
 */
@Service
public class LogHandler {

	ObjectMapper objectMapper = new ObjectMapper();

	org.slf4j.Logger logger;

	private static final String EXCEPTION_MESSAGE = "ERROR while parsing json : ";

	/**
	 * Logs into debug level with message
	 * @param message specific message to be logged
	 * @param object any object to be logged
	 * @param t the class from which the log is triggered
	 */
	public void logDebug(String message, Object object, Class<?> t) {

		logger = LoggerFactory.getLogger(t.getName());

		try {
			if (logger.isDebugEnabled())
				logger.debug("\n[" +message+ ":\n" + objectMapper
						.writeValueAsString(object)+"]"+"\n");
		} catch (JsonProcessingException e) {
			logger.error(String.format("%s%s", EXCEPTION_MESSAGE, e.getMessage()));
		}

	}

	/**
	 * Logs into info level with message, moduleName componentNam and componentName
	 * @param message specific message to be logged
	 * @param moduleName the name of the module of the project/ microservice
	 * @param componentName the name of the component (eg: User Management)
	 * @param object any object to be logged
	 *    * @param t the class from which the log is triggered
	 */
	public void logInfo(String message, String moduleName, String componentName, Object object, Class<?> t) {
		logger = LoggerFactory.getLogger(t.getName());
		try {
			if (logger.isInfoEnabled())
				logger.info("\n["+moduleName+"] [" +componentName+ "] [" +message+ ":\n" + objectMapper
						.writeValueAsString(object)+"]"+"\n");
		} catch (JsonProcessingException e) {
			logger.error(String.format("%s%s", EXCEPTION_MESSAGE, e.getMessage()));
		}

	}

	/**
	 * Logs into info level with message
	 * @param message specific message to be logged
	 * @param object any object to be logged
	 * @param t the class from which the log is triggered
	 */
	public void logInfo(String message, Object object, Class<?> t) {
		logger = LoggerFactory.getLogger(t.getName());
		try {
			if (logger.isInfoEnabled())
				logger.info("\n[" +message+ ":\n" +
						objectMapper.writeValueAsString(object)+"]"+"\n");
		} catch (JsonProcessingException e) {
			logger.error(String.format("%s%s", EXCEPTION_MESSAGE, e.getMessage()));
		}

	}

	/**
	 * Logs into error level with message, module name, component name and object
	 * @param message specific message to be logged
	 * @param moduleName the name of the module of the project/ microservice
	 * @param componentName the name of the component (eg: User Management)
	 * @param object any object to be logged
	 * @param t the class from which the log is triggered
	 */
	public void logError(String message, String moduleName, String componentName, Object object, Class<?> t) {
		logger = LoggerFactory.getLogger(t.getName());
		try {
			if (logger.isErrorEnabled())
				logger.error("\n["+moduleName+"] [" +componentName+ "] [" +message+ ":\n" + objectMapper
						.writeValueAsString(object)+"]"+"\n");
		} catch (JsonProcessingException e) {
			logger.error(String.format("%s%s", EXCEPTION_MESSAGE, e.getMessage()));
		}

	}

}
