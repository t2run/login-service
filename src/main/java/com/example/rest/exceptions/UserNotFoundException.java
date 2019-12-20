package com.example.rest.exceptions;

public class UserNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String arg0) {
		super(arg0);
		//System.out.println("User not found Exception");
	}
	
	

}
