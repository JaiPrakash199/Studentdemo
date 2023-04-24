package com.demo.student.exceptions;

public class StudentIdNotFoundException extends RuntimeException {

	public StudentIdNotFoundException(String string) {
		super(string);
	}
}
