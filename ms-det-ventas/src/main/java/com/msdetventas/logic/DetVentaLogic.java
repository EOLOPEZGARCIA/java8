package com.msdetventas.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msdetventas.service.DetVentaService;
import com.persistence.entity.DetVentas;
import com.persistence.repository.DetVentaRepository;
import com.persistence.request.DetVentaRequest;

@Service
public class DetVentaLogic implements DetVentaService {

	@Autowired
	DetVentaRepository repo;
	
	@Override
	public DetVentas guardar(DetVentaRequest request) {
		DetVentas prod= new DetVentas();
		prod.setCantidad(request.getCantidad());
		prod.setProductoId(request.getProductoId());
		prod.setVentaId(request.getVentaId());
		repo.save(prod);
		
		return prod;
	}

	@Override
	public DetVentas actualizar(DetVentaRequest request) {
		DetVentas prod= repo.findById(request.getDetVentaId()).get();
		prod.setCantidad(request.getCantidad());
		prod.setProductoId(request.getProductoId());
		prod.setVentaId(request.getVentaId());
		repo.save(prod);
		return prod;
	}

	@Override
	public DetVentas buscar(int id) {
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
