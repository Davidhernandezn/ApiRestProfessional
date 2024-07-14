package com.davidhernandezn.develop.ApiRest.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.davidhernandezn.develop.ApiRest.dto.ProductoDto;
import com.davidhernandezn.develop.ApiRest.model.Producto;

@Mapper(componentModel = "spring")//
public interface ProductoMapper {
	
	/*NOTA
	 * se utiliza para mapear entre la entidad Product y el objeto
	 * de transferencia de datos ProductDTO (Data Transfer Object). 
	 * Este mapeo es útil para separar la lógica de negocio y la estructura de 
	 * datos interna de la representación que se expone a través de la API REST.
	 * */
	
	//A LAS ENTIDADES LES TRANSFERIMOS LOS DTO
	Producto toProducto(ProductoDto productoDto);//PRODUCTOS PASAMOS DTO
	//TRANSFERIMOS LA ENTIDAD
	ProductoDto toProductoDto(Producto producto);//A LOS DTO LE PASAMOS PRODUCTOS
	
	//PASAMOS LA LISTA
	List<ProductoDto> toProductoDtos(List<Producto> productos);

	//ACTUALIZAR PRODUCTOS
	void updateProducto(@MappingTarget Producto producto, Producto productoDto);
}
