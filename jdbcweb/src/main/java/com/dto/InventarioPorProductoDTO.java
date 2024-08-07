package com.dto;

import java.sql.Date;
//dto es un modelo de una estructura virtual
//es un objeto pensado para la transmision de datos entre capas
//la informacion puede venir en diferentes origenes
public class InventarioPorProductoDTO {
	
	private String nombre;
	private Date fechaCad;
	private int stock;
	
	public InventarioPorProductoDTO() {
		
	}

	public InventarioPorProductoDTO(String nombre, Date fechaCad, int stock) {
		super();
		this.nombre = nombre;
		this.fechaCad = fechaCad;
		this.stock = stock;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaCad() {
		return fechaCad;
	}

	public void setFechaCad(Date fechaCad) {
		this.fechaCad = fechaCad;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "InventarioPorProductoDTO [nombre=" + nombre + ", fechaCad=" + fechaCad + ", stock=" + stock + "]";
	}
	
	

}
