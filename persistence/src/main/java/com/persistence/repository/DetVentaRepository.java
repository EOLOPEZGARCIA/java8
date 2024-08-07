package com.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.persistence.entity.DetVentas;

@Repository
public interface DetVentaRepository extends JpaRepository<DetVentas,Integer> {

}
