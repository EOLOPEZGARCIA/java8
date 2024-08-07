package com.msproductos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.msproductos.entity.Productos;
//DAO
//nos ahorra los metodos del dao ya es una interface que trae esos metodos solo se le dice de que entidad y cual es el tipo de dato de la llave
@Repository
public interface ProductoRepository extends JpaRepository<Productos,Integer> {

	//Consulta con JPQL(java persistence query languaje)
	@Query("SELECT p FROM Productos p WHERE p.nombre =:nombre")
	Optional<Productos> findByName(@Param("nombre")String nombre);
}
