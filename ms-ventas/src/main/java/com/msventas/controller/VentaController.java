package com.msventas.controller;

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

import com.msventas.logic.VentaLogic;
import com.persistence.entity.Ventas;
import com.persistence.request.VentaRequest;

@RestController
@RequestMapping("ventas/")
public class VentaController {
	
	@Autowired
	VentaLogic service;
	
	@GetMapping
	public ResponseEntity<List<Ventas>>mostrar(){
		List<Ventas> lista = service.mostrar();
		return new ResponseEntity<List<Ventas>>(lista,HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Ventas>guardar(@RequestBody VentaRequest request){
		Ventas prod = service.guardar(request);
		return new ResponseEntity<Ventas>(prod,HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Ventas>actualizar(@RequestBody VentaRequest request){
		Ventas prod= service.actualizar(request);
		return new ResponseEntity<Ventas>(prod,HttpStatus.OK);
	}
	
	@GetMapping("buscar/{id}")
	public ResponseEntity<Ventas> buscar(@PathVariable int id){
		Ventas prod = service.buscar(id);
		return new ResponseEntity<Ventas>(prod,HttpStatus.OK);
	}

	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<String> eliminar(@PathVariable int id){
		String response= service.eliminar(id);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
}
