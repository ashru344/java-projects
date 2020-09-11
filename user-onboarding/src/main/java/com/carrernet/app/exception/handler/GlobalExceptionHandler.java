package com.carrernet.app.exception.handler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.carrernet.app.exception.URLEncodeException;
import com.carrernet.app.exception.UserAlreadyRegisteredException;
import com.carrernet.app.model.HttpResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final String USER_ALREADY_REGISTERED = "You are already registered ! Please login to the application";
	private static final String INTERNAL_ERROR = "There is a server error , please check with admin";

	public ResponseEntity<HttpResponse> createHttpResponse(HttpStatus status, String message) {

		HttpResponse response = new HttpResponse(new Date(), status.value(), status,
				status.getReasonPhrase().toUpperCase(), message);

		return new ResponseEntity<>(response, status);
	}

	@ExceptionHandler(UserAlreadyRegisteredException.class)
	public ResponseEntity<HttpResponse> userAlreadExistException() {
		return createHttpResponse(BAD_REQUEST, USER_ALREADY_REGISTERED);
	}

	@ExceptionHandler(URLEncodeException.class)
	public ResponseEntity<HttpResponse> urlEncodeException() {
		return createHttpResponse(INTERNAL_SERVER_ERROR, INTERNAL_ERROR);
	}
}
