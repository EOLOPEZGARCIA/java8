package com.msproductos.controller;

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

import com.msproductos.entity.Productos;
import com.msproductos.logic.ProductoLogic;
import com.msproductos.request.ProductoRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("productos/")
public class ProductoController {
	
	@Autowired
	ProductoLogic service;
	//http://localhost:8090/productos/
	//GET
	@GetMapping
	public ResponseEntity<List<Productos>>mostrar(){
		List<Productos> lista = service.mostrar();
		return new ResponseEntity<List<Productos>>(lista,HttpStatus.OK);
	}
	//POST
	@PostMapping
	public ResponseEntity<Productos>guardar(@Valid @RequestBody ProductoRequest request){
		Productos prod = service.guardar(request);
		return new ResponseEntity<Productos>(prod,HttpStatus.OK);
	}
	//PUT
	@PutMapping
	public ResponseEntity<Productos>actualizar(@Valid @RequestBody ProductoRequest request){
		Productos prod = service.actualizar(request);
		return new ResponseEntity<Productos>(prod,HttpStatus.OK);
	}
	//buscar/10   GET
	@GetMapping("buscar/{id}")
	public ResponseEntity<Productos> buscar(@PathVariable int id){
		Productos prod = service.buscar(id);
		return new ResponseEntity<Productos>(prod,HttpStatus.OK);
	}
	//eliminar/8   DEKETE
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<String> eliminar(@PathVariable int id){
		String response= service.eliminar(id);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
	
	//buscar/galletas   GET
		@GetMapping("buscar-por-nombre/{nombre}")
		public ResponseEntity<Productos> buscar(@PathVariable String nombre){
			Productos prod = service.findByName(nombre);
			return new ResponseEntity<Productos>(prod,HttpStatus.OK);
		}

}
