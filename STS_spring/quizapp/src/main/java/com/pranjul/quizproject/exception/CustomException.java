package com.pranjul.quizproject.exception;

public class CustomException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8897508967518599242L;

	public CustomException(String message) {
		super(message);
	}

	public CustomException(String message,Throwable cause) {
		super(message,cause);
	}
}
