package com.demo.student.exceptions;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.student.responses.ErrorInfo;



@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handlingException(MethodArgumentNotValidException tx) {
		
		Map<String,String> errorMap=new LinkedHashMap<>();
		List<FieldError> list=tx.getFieldErrors();
		for(FieldError temp:list){
			String fieldName=temp.getField();
			String errorMsg=temp.getDefaultMessage();
			errorMap.put(fieldName, errorMsg);
		}
		ResponseEntity<Map<String,String>> rEntity=new ResponseEntity<Map<String,String>>(errorMap,HttpStatus.BAD_REQUEST);
		return rEntity;
	}
	@ExceptionHandler(StudentIdNotFoundException.class)
	public ResponseEntity<ErrorInfo> handlingException(StudentIdNotFoundException tx,HttpServletRequest request) {
		String msg=tx.getMessage();
		ErrorInfo eInfo=new ErrorInfo(LocalDateTime.now(),HttpStatus.NOT_FOUND.name(),msg,request.getRequestURI());
		ResponseEntity<ErrorInfo> rEntity=new ResponseEntity<ErrorInfo>(eInfo,HttpStatus.NOT_FOUND);
		return rEntity;
	}
	@ExceptionHandler(NoStudentFoundException.class)
	public ResponseEntity<String> handlingException(NoStudentFoundException tx) {
		String msg=tx.getMessage();
		ResponseEntity<String> rEntity=new ResponseEntity<String>(msg,HttpStatus.NO_CONTENT);
		return rEntity;
	}
	@ExceptionHandler(IdNotMatchedException.class)
	public ResponseEntity<String> handlingException(IdNotMatchedException tx) {
		String msg=tx.getMessage();
		ResponseEntity<String> rEntity=new ResponseEntity<String>(msg,HttpStatus.NOT_ACCEPTABLE);
		return rEntity;
	}
}
