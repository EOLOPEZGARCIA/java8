package com.msautos.controller;

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

import com.msautos.entity.Autos;
import com.msautos.logic.AutoLogic;
import com.msautos.request.AutoRequest;



@RestController
@RequestMapping("autos/")
public class AutoController {

	@Autowired
	AutoLogic service;
	//http://localhost:8090/productos/
	//GET
	@GetMapping
	public ResponseEntity<List<Autos>>mostrar(){
		List<Autos> lista = service.mostrar();
		return new ResponseEntity<List<Autos>>(lista,HttpStatus.OK);
	}
	//POST
	@PostMapping
	public ResponseEntity<Autos>guardar(@RequestBody AutoRequest request){
		Autos prod = service.guardar(request);
		return new ResponseEntity<Autos>(prod,HttpStatus.OK);
	}
	//PUT
	@PutMapping
	public ResponseEntity<Autos>actualizar(@RequestBody AutoRequest request){
		Autos prod = service.actualizar(request);
		return new ResponseEntity<Autos>(prod,HttpStatus.OK);
	}
	//buscar/10   GET
	@GetMapping("buscar/{id}")
	public ResponseEntity<Autos> buscar(@PathVariable int id){
		Autos prod = service.buscar(id);
		return new ResponseEntity<Autos>(prod,HttpStatus.OK);
	}
	//eliminar/8   DEKETE
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<String> eliminar(@PathVariable int id){
		String response= service.eliminar(id);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
}
