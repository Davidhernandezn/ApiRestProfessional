package com.davidhernandezn.develop.ApiRest.config;

import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.davidhernandezn.develop.ApiRest.dto.ErrorDto;
import com.davidhernandezn.develop.ApiRest.exception.AppException;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice //
public class GlobalExceptionHandler {
	
	//METODO NOS RESPONDE ERRORDTO // EXEPCIONES GLOBALMENTE
	@ExceptionHandler(AppException.class)
	@ResponseBody
	 public ResponseEntity<ErrorDto> response(AppException exception){
		 return ResponseEntity
				 .status(exception.getStatus())
				 .body(new ErrorDto(exception.getMessage()));
	 }
	
	
	//ERRORES DE VALIDACION tipo validate
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseBody
	public ResponseEntity<ErrorDto>responseEntity(ConstraintViolationException exception){
		String errorMensaje = "Error de validacion: "+exception.getConstraintViolations()
		.stream()
		.map(constraintViolation -> constraintViolation.getPropertyPath()+""+constraintViolation.getMessage())
		.collect(Collectors.joining(", "));//SI HAY VARIOS ERRORES LOS SEPARA POR UNA COMA
		
		return ResponseEntity.badRequest().body(new ErrorDto(errorMensaje));
	}
}
