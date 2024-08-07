package com.msautos.service;

import java.util.List;

import com.msautos.entity.Autos;
import com.msautos.request.AutoRequest;

public interface AutoService {
	
	Autos guardar(AutoRequest request);
	Autos actualizar(AutoRequest request);
	Autos buscar(int id);
	String eliminar(int id);
	List mostrar();
	

}
