package com.davidhernandezn.develop.ApiRest.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.davidhernandezn.develop.ApiRest.dto.ProductoDto;
import com.davidhernandezn.develop.ApiRest.exception.AppException;
import com.davidhernandezn.develop.ApiRest.mapper.ProductoMapper;
import com.davidhernandezn.develop.ApiRest.model.Producto;
import com.davidhernandezn.develop.ApiRest.repository.ProductoRepository;

//AGREGAMOS IMPLEMENT AL SERVICIO Y LOS IMPLEMENTAMOS
@Service
public class ProductoServiceImp implements ProductoService{
	
	//INYECCION DE DEPENDENCIAS
	private final ProductoRepository productoRepository;
	private final ProductoMapper productoMapper;
	
	//INYECCION POR EL CONSTRUCTOR
	public ProductoServiceImp(ProductoRepository productoRepository,ProductoMapper productoMapper) {
		this.productoRepository = productoRepository;
		this.productoMapper = productoMapper;
	}

	@Override
	public ProductoDto save(ProductoDto productoDto) {
		Boolean existProduct = productoRepository.existsByNombre(productoDto.getNombre());	
		if(!existProduct) {
			Producto producto = productoMapper.toProducto(productoDto);
			return productoMapper.toProductoDto(productoRepository.save(producto));
		}else {
			throw new AppException("El producto ya existe", HttpStatus.CONFLICT);
		}
	}
	
	@Override
	public List<ProductoDto> getProductos() {
		return productoMapper.toProductoDtos(productoRepository.findAll());
	}

	@Override
	public ProductoDto getProducto(Long productoId) {
		Producto producto = productoRepository.findById(productoId)
				.orElseThrow(()-> new AppException("Product not found", HttpStatus.NOT_FOUND));
		
		return productoMapper.toProductoDto(producto);
	}

	@Override
	public List<ProductoDto> getProductosCategoria(String categoria) {
		List<Producto> producto = productoRepository.findByCategoria(categoria);
		
		if (!categoria.isEmpty()) {
			return productoMapper.toProductoDtos(producto);
		}else {
			throw new AppException("Not founds products in category", HttpStatus.NOT_FOUND);
		}
	}
	

	@Override
	public ProductoDto update(Long productoId, ProductoDto productoDto) {
		//VALIDAR SI EXISTE PRODUCTO PARA ELIMINAR
		Producto producto = productoRepository.findById(productoId)
		.orElseThrow(() -> new AppException("Product not found", HttpStatus.NOT_FOUND));	
		productoMapper.updateProducto(producto, productoMapper.toProducto(productoDto));
		return productoMapper.toProductoDto(productoRepository.save(producto));
	}

	
	@Override
	public ProductoDto delete(Long productoId) {
		//VALIDAR SI EXISTE PRODUCTO PARA ELIMINAR
		Producto producto = productoRepository.findById(productoId)
		.orElseThrow(() -> new AppException("Product not found", HttpStatus.NOT_FOUND));
		
		ProductoDto productoDto = productoMapper.toProductoDto(producto);
		productoRepository.deleteById(productoId);
		return productoDto;
	}

}
