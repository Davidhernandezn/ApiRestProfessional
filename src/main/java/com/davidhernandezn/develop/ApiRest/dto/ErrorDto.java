package com.davidhernandezn.develop.ApiRest.dto;

public class ErrorDto {
	/*
	 * ErrorDto es una buena manera de estructurar y estandarizar
	 * las respuestas de error en tu API REST. Esto ayuda a los clientes de 
	 * tu API a entender los errores de una manera consistente. 
	 * */
	
	private String mensaje;
	
	//CONSTRUCTOR
	public ErrorDto(String mensaje) {
		this.mensaje = mensaje;
	}
	
	//METODO GER PARA EL MENSAJE
	public String getMensaje() {
		return mensaje;
	}

}
