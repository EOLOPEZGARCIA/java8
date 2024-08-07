package com.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="INVENTARIO")
public class Inventarios {

public Inventarios() {
		
	}

	public Inventarios(int id) {
		
		this.inventarioId = id;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="INVENTARIO_ID",columnDefinition="NUMBER")
	int inventarioId;
	
	@Column(name="STOCK",columnDefinition="NUMBER")
	int stock;
	@Column(name="FECHA",columnDefinition="DATE")
	Date fecha;
	
	@OneToOne
    @JoinColumn(name = "PRODUCTO_ID", updatable = false, nullable = false)
	@JsonBackReference
    private Productos producto;

	public int getInventarioId() {
		return inventarioId;
	}

	public void setInventarioId(int inventarioId) {
		this.inventarioId = inventarioId;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}
	
	
}
