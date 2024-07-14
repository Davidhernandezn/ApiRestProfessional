package com.davidhernandezn.develop.ApiRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davidhernandezn.develop.ApiRest.model.Producto;
import java.util.List;

/*
 * El ProductRepository es una interfaz que extiende JpaRepository para facilitar las operaciones de acceso 
 * a datos (CRUD) sobre la entidad Product. Esto es parte del patrón de diseño Repositorio, 
 * que separa la lógica de acceso a datos de la lógica de negocio.
 * 
 * El ProductRepository se usa para interactuar con la base de datos. 
 * Proporciona métodos estándar para realizar operaciones CRUD y también permite definir 
 * consultas personalizadas si es necesario.
 * */

@Repository														//REPRESENTA ENTIDAD Y TIPO DE DATO DE CLAVE PRIMARIA 
public interface ProductoRepository extends JpaRepository<Producto, Long> {

	//METODOS
	Boolean existByNombre(String nombre);//PREGUNTA SI EXIXTE EL NOMBRE GUARDADO PARA NO GUARDARSE 2 VECES
	
	List<Producto> findByCategoria(String categoria);//LISTAR PRODUCTOS CON LA MISMA CATEGORY
	
	
}
