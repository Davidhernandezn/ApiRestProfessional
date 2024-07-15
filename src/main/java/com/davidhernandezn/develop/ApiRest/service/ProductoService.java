package com.davidhernandezn.develop.ApiRest.service;

import java.util.List;

import com.davidhernandezn.develop.ApiRest.dto.ProductoDto;

public interface ProductoService {
	/*
	 *  especifica los métodos que deben ser implementados por cualquier clase 
	 *  que gestione la lógica de negocio relacionada con productos. 
	 * */
	
	//SOLO DEFINE METODOS PERO NO LO IMPLEMENTA
	
	public ProductoDto save(ProductoDto productoDto); //METODO GUARDAR UN PRODUCTO DTO,
	
	public List<ProductoDto> getProductos();
	
	public ProductoDto getProducto(Long productoId); 
	
	public List<ProductoDto> getProductosCategoria(String categoria);
	
	public ProductoDto update(Long productoId, ProductoDto productoDto);
	
	public ProductoDto delete(Long productoId);
}
