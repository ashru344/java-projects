package com.carrernet.app.exception;

public class UserAlreadyRegisteredException extends BaseException {

	private static final long serialVersionUID = 5932067407679034332L;

	public UserAlreadyRegisteredException() {
		super();
	}

	public UserAlreadyRegisteredException(String message) {
		super(message);
	}
}