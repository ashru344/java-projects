package com.carrernet.app.exception;

public class BaseException extends RuntimeException {

	private static final long serialVersionUID = 3444502109856762855L;

	public BaseException() {
		super();
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseException(String message) {
		super(message);
	}

	public BaseException(Throwable cause) {
		super(cause);
	}

}
