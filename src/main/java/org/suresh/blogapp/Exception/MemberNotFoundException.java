package org.suresh.blogapp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MemberNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1798221362288065433L;

	@ExceptionHandler
	public ResponseEntity<Object> exception(MemberNotFoundException ex){
		return new ResponseEntity<>("Member not present",HttpStatus.NOT_FOUND);	
	}
}
