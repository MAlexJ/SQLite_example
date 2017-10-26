package com.malexj.app.exception;

public class AppException extends RuntimeException{

	public AppException() {
	}

	public AppException(String message) {
		super(message);
	}

	public AppException(String message, Throwable cause) {
		super(message, cause);
	}
}
