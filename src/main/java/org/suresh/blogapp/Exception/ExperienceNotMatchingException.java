package org.suresh.blogapp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExperienceNotMatchingException extends RuntimeException{

	private static final long serialVersionUID = -7018438604953860367L;

	@ExceptionHandler
	public ResponseEntity<Object> exception(ExperienceNotMatchingException ex) {
		return new ResponseEntity<>("Minimum 4 years experience required",HttpStatus.NOT_FOUND);	
	}

}
