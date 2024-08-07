package com.mscustomers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mscustomers.logic.ClienteLogic;
import com.persistence.entity.Clientes;
import com.persistence.request.ClienteRequest;

@RestController
@RequestMapping("clientes/")
public class ClienteController {
	
	@Autowired
	ClienteLogic service;
	
	@GetMapping
	public ResponseEntity<List<Clientes>>mostrar(){
		List<Clientes> lista = service.mostrar();
		return new ResponseEntity<List<Clientes>>(lista,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Clientes>guardar(@RequestBody ClienteRequest request){
		Clientes prod = service.guardar(request);
		return new ResponseEntity<Clientes>(prod,HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Clientes>actualizar(@RequestBody ClienteRequest request){
		Clientes prod= service.actualizar(request);
		return new ResponseEntity<Clientes>(prod,HttpStatus.OK);
	}
	
	@GetMapping("buscar/{id}")
	public ResponseEntity<Clientes> buscar(@PathVariable int id){
		Clientes prod = service.buscar(id);
		return new ResponseEntity<Clientes>(prod,HttpStatus.OK);
	}
	
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<String> eliminar(@PathVariable int id){
		String response= service.eliminar(id);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}

}
