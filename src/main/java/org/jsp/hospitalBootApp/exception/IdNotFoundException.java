package org.jsp.hospitalBootApp.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class IdNotFoundException extends RuntimeException{
	@Override
	public String getMessage() {
		return "Id Not Found";
	}
}
