package com.mscustomers.service;

import java.util.List;

import com.persistence.entity.Clientes;
import com.persistence.request.ClienteRequest;

public interface ClienteService {
	
	Clientes guardar (ClienteRequest request);
	Clientes actualizar (ClienteRequest request);
	Clientes buscar (int id);
	String eliminar (int id);
	List mostrar();

}
