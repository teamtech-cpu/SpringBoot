package com.in28minutes.restServices.restfulwebservices.exception;

import java.time.LocalDate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CustomizedExceptionResponseEntity  extends ResponseEntityExceptionHandler{
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		ErrorDetials errorDetials=new ErrorDetials(LocalDate.now(),
				ex.getMessage(), request.getDescription(false));
		 return new ResponseEntity(errorDetials,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleNotFoundException(Exception ex, WebRequest request) throws Exception {
		ErrorDetials errorDetials=new ErrorDetials(LocalDate.now(),
				ex.getMessage(), request.getDescription(false));
		 return new ResponseEntity(errorDetials,HttpStatus.NOT_FOUND);
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorDetials errorDetials=new ErrorDetials(LocalDate.now(),
				"Total Errors:"+ex.getFieldErrorCount(
						)+""+ex.getFieldError().getDefaultMessage(), 
				request.getDescription(false));
		
		 return new ResponseEntity(errorDetials,HttpStatus.BAD_REQUEST);
	}

}
