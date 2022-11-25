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
public class MemberInformationNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 6086004711190107088L;

	@ExceptionHandler
	public ResponseEntity<Object> exception(MemberInformationNotFoundException ex){
		return new ResponseEntity<>("Member information should not be null or empty",HttpStatus.NOT_FOUND);	
	}

}
