package com.dto;

import java.sql.Date;

public class DetalleVentaDTO {
	
	private String departamento;
	private Date fechaVenta;
	private int cantidad;
	private String producto;
	
	
	public DetalleVentaDTO() {
		
	}


	public DetalleVentaDTO(String departamento, Date fechaVenta, int cantidad, String producto) {
		super();
		this.departamento = departamento;
		this.fechaVenta = fechaVenta;
		this.cantidad = cantidad;
		this.producto = producto;
	}


	public String getDepartamento() {
		return departamento;
	}


	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}


	public Date getFechaVenta() {
		return fechaVenta;
	}


	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public String getProducto() {
		return producto;
	}


	public void setProducto(String producto) {
		this.producto = producto;
	}


	@Override
	public String toString() {
		return "DetalleVentaDTO [departamento=" + departamento + ", fechaVenta=" + fechaVenta + ", cantidad=" + cantidad
				+ ", producto=" + producto + "]";
	}
	
	
	

}
