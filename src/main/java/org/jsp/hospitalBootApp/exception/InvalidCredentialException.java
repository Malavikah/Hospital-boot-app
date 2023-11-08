package org.jsp.hospitalBootApp.exception;

public class InvalidCredentialException extends RuntimeException{
	@Override
	public String getMessage() {
		return "Invalid id or phone or email";
	}
}
