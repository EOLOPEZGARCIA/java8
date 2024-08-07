package com.msventas.service;

import java.util.List;

import com.persistence.entity.Ventas;
import com.persistence.request.VentaRequest;


public interface VentaService {
	
	Ventas guardar (VentaRequest request);
	Ventas actualizar (VentaRequest request);
	Ventas buscar (int id);
	String eliminar (int id);
	List mostrar();

}
