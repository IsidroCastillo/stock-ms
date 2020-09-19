package com.everis.school.stockms.exception;

import java.time.Instant;

import lombok.Getter;

@Getter
public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;

	private String message;

	private Instant date;

	public BusinessException(String message) {
		this.message = message;
		this.date = Instant.now();

	}

}