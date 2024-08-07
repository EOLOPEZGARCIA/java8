package com.msdetventas.controller;

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

import com.msdetventas.logic.DetVentaLogic;
import com.persistence.entity.DetVentas;
import com.persistence.request.DetVentaRequest;

@RestController
@RequestMapping("detalle-ventas/")
public class DetVentaController {
	
	@Autowired
	DetVentaLogic service;
	
	@GetMapping
	public ResponseEntity<List<DetVentas>>mostrar(){
		List<DetVentas> lista = service.mostrar();
		return new ResponseEntity<List<DetVentas>>(lista,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<DetVentas>guardar(@RequestBody DetVentaRequest request){
		DetVentas prod = service.guardar(request);
		return new ResponseEntity<DetVentas>(prod,HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<DetVentas>actualizar(@RequestBody DetVentaRequest request){
		DetVentas prod= service.actualizar(request);
		return new ResponseEntity<DetVentas>(prod,HttpStatus.OK);
	}

	@GetMapping("buscar/{id}")
	public ResponseEntity<DetVentas> buscar(@PathVariable int id){
		DetVentas prod = service.buscar(id);
		return new ResponseEntity<DetVentas>(prod,HttpStatus.OK);
	}
	
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<String> eliminar(@PathVariable int id){
		String response= service.eliminar(id);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}

}
