package com.davidhernandezn.develop.ApiRest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "productos")
public class Producto {

	@NotNull
	private Long id;

	@NotNull
	private String nombre;
	
	@NotNull
	private String categoria;
	
	@NotNull
	private Double precio;
	
	@NotNull
	@Min(1)
	private Integer catidad;
	
	
	/*Requerido por JPA: JPA requiere un constructor sin parámetros para poder crear instancias
	 * de las entidades mediante reflexión. Sin este constructor, JPA no podrá instanciar la entidad 
	 * desde la base de datos.

	 * Facilidad de uso: Un constructor sin parámetros permite crear una instancia de la entidad y luego establecer sus propiedades mediante los setters. Esto es útil en situaciones donde no tienes todos los datos del objeto disponibles en el momento de la creación.*/
	//CONSTRUCTOR SIN PARAMETROS
	public Producto(){
	}

	
	//CONSTRUCTOR CON PARAMETROS
	/*Inmutabilidad parcial: Puedes crear instancias completas del objeto de una sola vez, 
	 * 						lo que puede ayudar a asegurar que el objeto esté en un estado válido desde el momento de su creación.
	
	 *Conveniencia: Facilita la creación rápida de objetos con valores predefinidos, 
	 *				especialmente en pruebas y ejemplos.*/
	public Producto(Long id, String nombre, String categoria, Double precio,Integer catidad) {
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.catidad = catidad;
	}

	
	//Getter and Setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCatidad() {
		return catidad;
	}

	public void setCatidad(Integer catidad) {
		this.catidad = catidad;
	}
		
}
