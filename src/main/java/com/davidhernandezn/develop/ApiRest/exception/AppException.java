package com.davidhernandezn.develop.ApiRest.exception;

import org.springframework.http.HttpStatus;

public class AppException extends RuntimeException{
	/*La clase AppException es una excelente manera de manejar excepciones personalizadas en tu API REST. 
	 *Esta clase permite asociar un mensaje de error y un estado HTTP con la excepción, lo que facilita 
	 *el manejo y la respuesta adecuada a los errores en tu aplicación.*/
	
	//RECIBE EL STATUS QUE GENERE LA EXCEPTION
	private final HttpStatus status;

	public AppException(String mensaje, HttpStatus status) {
		super(mensaje);
		this.status = status;
	}
	
	//METODO
	public HttpStatus getStatus() {
		return status;
	}
}
