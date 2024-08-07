package com.msempleados.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msempleados.service.EmpleadoService;
import com.persistence.entity.Empleados;
import com.persistence.repository.EmpleadoRepository;
import com.persistence.request.EmpleadoRequest;

@Service
public class EmpleadoLogic implements EmpleadoService{
	
	@Autowired
	EmpleadoRepository repo;

	@Override
	public Empleados guardar(EmpleadoRequest request) {

		Empleados prod=new Empleados();
		prod.setFechaIngreso(request.getFechaIngreso());
		prod.setNombre(request.getNombre());
		prod.setSalario(request.getSalario());
		repo.save(prod);
		return prod;
	}

	@Override
	public Empleados actualizar(EmpleadoRequest request) {

		Empleados prod=repo.findById(request.getEmpleadoId()).get();
		prod.setFechaIngreso(request.getFechaIngreso());
		prod.setNombre(request.getNombre());
		prod.setSalario(request.getSalario());
		repo.save(prod);
		return prod;
	}

	@Override
	public Empleados buscar(int id) {
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
