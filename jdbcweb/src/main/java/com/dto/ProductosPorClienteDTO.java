package com.dto;

import java.util.List;

public class ProductosPorClienteDTO {
	
	private String cliente;
	private List<DetalleVentaDTO> detalles;
	
	public ProductosPorClienteDTO() {
		
	}

	public ProductosPorClienteDTO(String cliente, List<DetalleVentaDTO> detalles) {
		super();
		this.cliente = cliente;
		this.detalles = detalles;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public List<DetalleVentaDTO> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleVentaDTO> detalles) {
		this.detalles = detalles;
	}

	@Override
	public String toString() {
		return "ProductosPorClienteDTO [cliente=" + cliente + ", detalles=" + detalles + "]";
	}
	
	
	
}
