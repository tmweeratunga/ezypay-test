package com.ezypay.util.exception;


import com.ezypay.dto.util.EZYPAYError;

public class EZYPayException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8362298626912267189L;

	/** The exception msg. */
	private String exceptionMsg;

	private EZYPAYError ezypayError;

	/**
	 * Instantiates a new LMS exception.
	 *
	 * @param exceptionMsgVal
	 *            the exception msg val
	 * @param e
	 *            the e
	 */
	public EZYPayException(final String exceptionMsgVal, final Throwable e) {
		super(exceptionMsgVal, e);
		this.exceptionMsg = exceptionMsgVal;
	}

	/**
	 * Instantiates a new LMS exception.
	 *
	 * @param exceptionMsgVal
	 *            the exception msg val
	 */
	public EZYPayException(final String exceptionMsgVal) {
		this.exceptionMsg = exceptionMsgVal;
	}

	public EZYPayException(final EZYPAYError ezypayError) {
		this.ezypayError = ezypayError;
	}

	/**
	 * Gets the exception msg.
	 *
	 * @return the exception msg
	 */
	public String getExceptionMsg() {
		return this.exceptionMsg;
	}

	public EZYPAYError getEzypayError() {
		return ezypayError;
	}

	/**
	 * Sets the exception msg.
	 *
	 * @param exceptionMsgVal
	 *            the new exception msg
	 */
	public void setExceptionMsg(final String exceptionMsgVal) {
		this.exceptionMsg = exceptionMsgVal;
	}

	@Override
	public String toString() {
		return "EZYPayException{" +
				"exceptionMsg='" + exceptionMsg + '\'' +
				", ezypayError=" + ezypayError +
				'}';
	}
}
