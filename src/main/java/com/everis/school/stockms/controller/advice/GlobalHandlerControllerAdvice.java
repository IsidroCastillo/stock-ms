package com.everis.school.stockms.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.everis.school.stockms.dto.ErrorDetailDto;
import com.everis.school.stockms.exception.BusinessException;

@ControllerAdvice
public class GlobalHandlerControllerAdvice {

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ErrorDetailDto> businessException(BusinessException exception) {
		return new ResponseEntity<>(new ErrorDetailDto(exception.getMessage(), exception.getDate()), HttpStatus.OK);
	}

}
