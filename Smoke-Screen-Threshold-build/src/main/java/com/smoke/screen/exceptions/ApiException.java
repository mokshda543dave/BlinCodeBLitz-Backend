package com.smoke.screen.exceptions;

public class ApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ApiException(String message) {
		super(message);

	}

	public ApiException() {
		super();

	}

}
