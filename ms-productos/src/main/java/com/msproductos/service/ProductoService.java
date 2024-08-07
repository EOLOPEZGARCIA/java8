package com.msproductos.service;

import java.util.List;

import com.msproductos.entity.Productos;
import com.msproductos.request.ProductoRequest;

//enlista las cosas que va a hacer este proyecto
public interface ProductoService {
	
	Productos guardar(ProductoRequest request);
	Productos actualizar(ProductoRequest request);
	Productos buscar(int id);
	String eliminar(int id);
	List mostrar();

}
