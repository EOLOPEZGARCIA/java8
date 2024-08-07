package com.mscustomers.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mscustomers.service.ClienteService;
import com.persistence.entity.Clientes;
import com.persistence.repository.ClienteRepository;
import com.persistence.request.ClienteRequest;

@Service
public class ClienteLogic implements ClienteService {

	@Autowired
	ClienteRepository repo;
	
	@Override
	public Clientes guardar(ClienteRequest request) {
		
		Clientes prod = new Clientes();
		prod.setNombre(request.getNombre());
		prod.setDomicilio(request.getDomicilio());
		prod.setFechaNac(request.getFechaNac());
		repo.save(prod);
		return prod;
	}

	@Override
	public Clientes actualizar(ClienteRequest request) {
		Clientes prod = repo.findById(request.getClienteId()).get();
		prod.setNombre(request.getNombre());
		prod.setDomicilio(request.getDomicilio());
		prod.setFechaNac(request.getFechaNac());
		repo.save(prod);
		return prod;
	}

	@Override
	public Clientes buscar(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public String eliminar(int id) {
		repo.deleteById(id);
		return "ELIMINADO";
	}

	@Override
	public List mostrar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
