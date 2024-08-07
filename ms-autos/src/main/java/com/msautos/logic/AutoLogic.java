package com.msautos.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msautos.entity.Autos;
import com.msautos.repository.AutoRepository;
import com.msautos.request.AutoRequest;
import com.msautos.service.AutoService;

@Service
public class AutoLogic implements AutoService{
	
	@Autowired
	AutoRepository repo;

	@Override
	public Autos guardar(AutoRequest request) {
		// TODO Auto-generated method stub
		Autos prod = new Autos();
		prod.setAno(request.getAno());
		prod.setModelo(request.getModelo());
		prod.setMarcaId(request.getMarcaId());
		prod.setTipo(request.getTipo());
		repo.save(prod);
		return prod;
	}

	@Override
	public Autos actualizar(AutoRequest request) {
		
		Autos prod = repo.findById(request.getModeloId()).get();
		prod.setAno(request.getAno());
		prod.setModelo(request.getModelo());
		prod.setMarcaId(request.getMarcaId());
		prod.setTipo(request.getTipo());
		repo.save(prod);
		return prod;
	}

	@Override
	public Autos buscar(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public String eliminar(int id) {
		repo.deleteById(id);
		return "Eliminado";
	}

	@Override
	public List mostrar() {
		return repo.findAll();
	}

}
