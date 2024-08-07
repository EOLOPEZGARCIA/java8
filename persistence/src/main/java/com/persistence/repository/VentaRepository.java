package com.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.persistence.entity.Ventas;

@Repository
public interface VentaRepository extends JpaRepository<Ventas,Integer> {

}
