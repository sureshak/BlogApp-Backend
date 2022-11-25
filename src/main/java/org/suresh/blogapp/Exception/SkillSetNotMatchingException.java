/**
 * 
 */
package org.suresh.blogapp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author cogjava3381
 *
 */
@ControllerAdvice
public class SkillSetNotMatchingException extends RuntimeException{

	private static final long serialVersionUID = 5362283510293480528L;

	@ExceptionHandler
	public ResponseEntity<Object> exception(SkillSetNotMatchingException ex){
		return new ResponseEntity<>("Minimum 3 skill set required",HttpStatus.NOT_FOUND);	
	}
}
