package com.davidhernandezn.develop.ApiRest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davidhernandezn.develop.ApiRest.dto.ProductoDto;
import com.davidhernandezn.develop.ApiRest.service.ProductoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ProductoController {
	
	//INYECTAR PRODUCT SERVICE TIENE QUE SER LA INTERFACE
	private final ProductoService productService;
	
	//INYECTAMOS EL CONSTRUCTOR A PRODUCTO SERVICE
	public ProductoController(ProductoService productService) {
		this.productService = productService;
	} 
	
	//REGISTRAR PRODUCTO
	@PostMapping("/producto")
	public ResponseEntity<ProductoDto> saveProduct(@Valid @RequestBody ProductoDto productoDto){
		return new ResponseEntity<>(productService.save(productoDto), HttpStatus.CREATED);
	}
	
	//LISTAR PRODUCTOS
	@GetMapping("/producto")
	public ResponseEntity<List<ProductoDto>> getProductos(){
		return new ResponseEntity<>(productService.getProductos(), HttpStatus.OK);
	}	
	
	//BUSQUEDA
	@GetMapping("/producto/{productoId}")
	public ResponseEntity<ProductoDto> getProducto(@PathVariable Long productoId){
		return new ResponseEntity<>(productService.getProducto(productoId), HttpStatus.OK);
	}
	
	//LISTAR POR CATEGORIA
	@GetMapping("/producto/categoria/{nombre}")
	public ResponseEntity<List<ProductoDto>> getProductosCategoria(@PathVariable String nombre){
		return new ResponseEntity<>(productService.getProductosCategoria(nombre), HttpStatus.OK);
	}
	
	//ACTUALIZAR
	@PutMapping("/producto/{productoId}")
	public ResponseEntity<ProductoDto> updateProducto(@PathVariable Long productoId, @RequestBody ProductoDto productoDto){
		return new ResponseEntity<>(productService.update(productoId, productoDto), HttpStatus.OK);
	}
	
	//ELIMINAR
	@DeleteMapping("producto/{productoId}")
	public ResponseEntity<ProductoDto> deleteProducto(@PathVariable Long productoId){
		return new ResponseEntity<>(productService.delete(productoId), HttpStatus.OK);
	}
}