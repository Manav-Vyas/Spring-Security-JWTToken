package com.springsecurity.Exception;

public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException(Exception ex) {
		super("User Not found on user");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
