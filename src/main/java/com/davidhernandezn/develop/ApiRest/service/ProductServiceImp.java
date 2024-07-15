package com.davidhernandezn.develop.ApiRest.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.davidhernandezn.develop.ApiRest.dto.ProductoDto;
import com.davidhernandezn.develop.ApiRest.exception.AppException;
import com.davidhernandezn.develop.ApiRest.mapper.ProductoMapper;
import com.davidhernandezn.develop.ApiRest.model.Producto;
import com.davidhernandezn.develop.ApiRest.repository.ProductoRepository;

//AGREGAMOS IMPLEMENT AL SERVICIO Y LOS IMPLEMENTAMOS
public class ProductServiceImp implements ProductoService{
	
	//INYECCION DE DEPENDENCIAS
	private final ProductoRepository productoRepository;
	private final ProductoMapper productoMapper;
	
	//INYECCION POR EL CONSTRUCTOR
	public ProductServiceImp(ProductoRepository productoRepository,ProductoMapper productoMapper) {
		this.productoRepository = productoRepository;
		this.productoMapper = productoMapper;
	}

	@Override
	public ProductoDto save(ProductoDto productoDto) {
		Boolean existProduct = productoRepository.existByNombre(productoDto.getNombre());	
		if(!existProduct) {
			Producto producto = productoMapper.toProducto(productoDto);
			return productoMapper.toProductoDto(productoRepository.save(producto));
		}else {
			throw new AppException("El producto ya existe", HttpStatus.CONFLICT);
		}
	}

	
	@Override
	public List<ProductoDto> getProductos() {
		// TODO Auto-generated method stub
		return productoMapper.toProductoDtos(productoRepository.findAll());
	}

	@Override
	public ProductoDto getProducto(Long productoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductoDto> getProductosCategoria(String categoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductoDto update(Long productoId, ProductoDto productoDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductoDto delete(Long productoId) {
		// TODO Auto-generated method stub
		return null;
	}

}
