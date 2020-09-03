package com.ezypay.util.exception;

import com.ezypay.dto.util.EZYPAYError;
import com.ezypay.dto.util.EZYPAYResponse;
import com.ezypay.enumerations.ErrorMessageEnum;
import com.ezypay.util.logs.LogHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


//@EnableWebMvc
@ControllerAdvice
public class EZYPayExceptionHandler {

	/** The Constant STATUS_MESSAGE. */
	public static final String STATUS_MESSAGE = "EZYP-message";
	public static final String SERVER_ERROR_MESSAGE = "The server has gone for a coffee break. It will be back very " +
			"soon.";

	private String moduleName = "back-office-service";
	private String componentName = "ExceptionHandling";

	@Autowired
	private LogHandler logHandler;

	/**
	 * Handle null pointer.
	 *
	 * @param exception
	 *            the exception
	 * @return the response entity
	 */
	@ExceptionHandler(NullPointerException.class)
	@ResponseBody
	public ResponseEntity<EZYPAYResponse> handleNullPointer(NullPointerException exception) {

		logHandler.logError("Null PointerException ", moduleName, componentName, exception, this.getClass());

		EZYPAYResponse responseToUser = new EZYPAYResponse();
		EZYPAYError errorToUser = new EZYPAYError();
		errorToUser.setError(ErrorMessageEnum.NULL_POINTER_EXCEPTION);
		errorToUser.setErrorMessage(SERVER_ERROR_MESSAGE);
		responseToUser.setError(errorToUser);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set(STATUS_MESSAGE, exception.getMessage());

		return new ResponseEntity<EZYPAYResponse>(responseToUser, responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(EZYPayException.class)
	@ResponseBody
	public ResponseEntity<EZYPAYResponse> handleEZYPayExceptions(EZYPayException exception){

		logHandler.logInfo("EZYPAY Exception is ", moduleName, componentName, exception,
				this.getClass());

		EZYPAYResponse responseToUser = new EZYPAYResponse();
		responseToUser.setError(exception.getEzypayError());

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set(STATUS_MESSAGE, exception.getExceptionMsg());

		return new ResponseEntity<EZYPAYResponse>(responseToUser, responseHeaders, HttpStatus.OK);

	}

	/**
	 * Handle top level exception.
	 *
	 * @param exception
	 *            the exception
	 * @return the response entity
	 */
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public ResponseEntity<EZYPAYResponse> handleTopLevelException(RuntimeException exception) {

		logHandler.logError("Runtime Exception ", moduleName, componentName, exception,
				this.getClass());
		EZYPAYResponse responseToUser = new EZYPAYResponse();
		EZYPAYError ezypayError = new EZYPAYError();
		ezypayError.setErrorCode(ErrorMessageEnum.RUNTIME_EXCEPTION.getErrorCode());
		ezypayError.setErrorMessage(SERVER_ERROR_MESSAGE);
		responseToUser.setError(ezypayError);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set(STATUS_MESSAGE, SERVER_ERROR_MESSAGE);

		return new ResponseEntity<EZYPAYResponse>(responseToUser, responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
	}


}
