package com.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.persistence.entity.Empleados;

@Repository
public interface EmpleadoRepository  extends JpaRepository<Empleados,Integer>  {

}
