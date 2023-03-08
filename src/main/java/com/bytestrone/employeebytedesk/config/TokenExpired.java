package com.bytestrone.employeebytedesk.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.jsonwebtoken.ExpiredJwtException;

public class TokenExpired extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ExceptionHandler(value = { ExpiredJwtException.class })
	public ResponseEntity<Object> handleTokenExpiredException() {
		String errorMessage = "Token has been Expired";
		return new ResponseEntity<>(errorMessage, HttpStatus.UNAUTHORIZED);
	}
}
