package com.msproductos.logic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msproductos.entity.Productos;
import com.msproductos.exception.BusinessException;
import com.msproductos.exception.IdNotFoundException;
import com.msproductos.exception.ResourceNotFoundException;
import com.msproductos.repository.ProductoRepository;
import com.msproductos.request.ProductoRequest;
import com.msproductos.service.ProductoService;
import com.msproductos.constants.*;

@Service
public class ProductoLogic implements ProductoService{

	//Inyeccion de depndencias   
	//hay 3 tipos de 
	@Autowired
	ProductoRepository repo;
	
	
	@Override
	public Productos guardar(ProductoRequest request) {
		
		Productos prod =null;
		if(repo.findByName(request.getNombre()).isPresent()) {
			//Lanzar intencionalmente la excepcion
			throw new BusinessException(Constants.PRODUCTO_REPETIDO);
		}else {
			prod = new Productos();
			prod.setDeptoId(request.getDeptoId());
			prod.setFecha(request.getFecha());
			prod.setNombre(request.getNombre());
			prod.setPrecioCompra(request.getPrecioCompra());
			prod.setPrecioVenta(request.getPrecioVenta());
			prod.setRefrigerado(request.getRefrigerado());
			repo.save(prod);
		}
		
		return prod;
	}

	@Override
	public Productos actualizar(ProductoRequest request) {
		
		Productos prod = repo.findById(request.getProductoId()).get();
		prod.setDeptoId(request.getDeptoId());
		prod.setFecha(request.getFecha());
		prod.setNombre(request.getNombre());
		prod.setPrecioCompra(request.getPrecioCompra());
		prod.setPrecioVenta(request.getPrecioVenta());
		prod.setRefrigerado(request.getRefrigerado());
		repo.save(prod);
		return prod;
	}

	@Override
	public Productos buscar(int id) {
		Productos prod =null;
		if(repo.findById(id).isPresent()) {
			prod=repo.findById(id).get();
		}else {
			throw new IdNotFoundException(Constants.RECURSO_NO_ENCONTRADO);
			//BusinessException("No existe un producto con este id");
		}
		
		return prod;
	}

	@Override
	public String eliminar(int id) {
		repo.deleteById(id);
		return "Eliminado";
	}

	@Override
	public List mostrar() {
		
		if(repo.findAll().size()<1) {
			throw new ResourceNotFoundException(Constants.DATOS_NO_EXISTENTES);
		}else {
		return repo.findAll();
		}
	}
	
	public Productos findByName(String nombre) {
		return repo.findByName(nombre).get();
	}

}
