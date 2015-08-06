package com.crontab;

import com.ssc.faw.util.GenException;

public class OrderValidationException extends GenException{

	/**
     * default version id.
     */
    private static final long serialVersionUID = 1L;
    
	private String errorLevel;
	private String errorMessage;
	public String getErrorLevel() {
		return errorLevel;
	}
	public void setErrorLevel(String errorLevel) {
		this.errorLevel = errorLevel;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public OrderValidationException(int errorCode, String errorLevel,
			Throwable t) {
		super(errorCode, errorLevel, t);
		
		this.errorLevel = errorLevel;
	}
	public OrderValidationException(int errorCode, String errorLevel,String errorMessage,
			Throwable t) {
		super(errorCode, errorLevel,errorMessage, t);
		
		this.errorLevel = errorLevel;
		this.errorMessage = errorMessage;
	}

}
