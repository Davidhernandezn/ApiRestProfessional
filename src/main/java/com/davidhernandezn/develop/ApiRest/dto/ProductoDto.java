package com.davidhernandezn.develop.ApiRest.dto;

public class ProductoDto {
	/*NOTAS
	 * Encapsulamiento de Datos: Los DTOs permiten encapsular y transferir solo los datos necesarios entre las capas de tu aplicación, lo que ayuda a mantener la estructura interna de tus entidades de base de datos oculta del cliente.
	 
	 * Seguridad: Evita la exposición de información sensible o interna de tus entidades. Puedes controlar exactamente qué campos se envían y reciben.

     * Desacoplamiento: Los DTOs ayudan a desacoplar las capas de presentación y de servicio. Esto facilita el cambio de la lógica interna sin afectar la interfaz pública de la API.

	 * Validación: Los DTOs pueden usarse para validar los datos de entrada antes de que lleguen a las entidades y la lógica de negocio. Puedes usar anotaciones de validación de Java (como @NotNull, @Size, @Email, etc.) en los DTOs.

     * Manejo de Complejidad: Al usar DTOs, puedes mapear datos entre diferentes modelos (por ejemplo, de una estructura compleja de entidad a una estructura más simple y específica para la API).
	 * */
	
	
	//MISMOS ATRIBUTOS QUE CLASE ENTIDAD PRODUCTO
	private Long id;

	private String nombre;
	
	private String categoria;
	
	private Double precio;
	
	private Integer cantidad;
		
	//CONSTRUCTOR VACIO
	public ProductoDto() {
	}

	//CONSTRUCTOR CON PARAMETROS
	public ProductoDto(Long id, String nombre, String categoria, Double precio, Integer cantidad) {
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	

	//GETTER AND SETTER
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

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
}
