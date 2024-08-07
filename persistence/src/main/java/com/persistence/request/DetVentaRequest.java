package com.persistence.request;

import java.sql.Date;

public class DetVentaRequest {
	private int detVentaId;
	private int ventaId;
	private int productoId;
	private int cantidad;
	
	public DetVentaRequest() {
		
	}

	public DetVentaRequest(int detVentaId, int ventaId, int productoId, int cantidad) {
		super();
		this.detVentaId = detVentaId;
		this.ventaId = ventaId;
		this.productoId = productoId;
		this.cantidad = cantidad;
	}

	public int getDetVentaId() {
		return detVentaId;
	}

	public void setDetVentaId(int detVentaId) {
		this.detVentaId = detVentaId;
	}

	public int getVentaId() {
		return ventaId;
	}

	public void setVentaId(int ventaId) {
		this.ventaId = ventaId;
	}

	public int getProductoId() {
		return productoId;
	}

	public void setProductoId(int productoId) {
		this.productoId = productoId;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "DetVentaRequest [detVentaId=" + detVentaId + ", ventaId=" + ventaId + ", productoId=" + productoId
				+ ", cantidad=" + cantidad + "]";
	}
	
	

}
