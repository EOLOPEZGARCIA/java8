package com.msdetventas.service;

import java.util.List;

import com.persistence.entity.DetVentas;
import com.persistence.request.DetVentaRequest;


public interface DetVentaService {

	DetVentas guardar (DetVentaRequest request);
	DetVentas actualizar (DetVentaRequest request);
	DetVentas buscar (int id);
	String eliminar (int id);
	List mostrar();
}
