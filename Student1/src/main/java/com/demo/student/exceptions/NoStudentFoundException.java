package com.demo.student.exceptions;

public class NoStudentFoundException extends RuntimeException {

	public NoStudentFoundException(String string) {
		super(string);
	}
}
