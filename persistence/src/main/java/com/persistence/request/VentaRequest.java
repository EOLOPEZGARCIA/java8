package com.persistence.request;

import java.sql.Date;
import java.util.List;

import com.persistence.dto.DetalleVentaDTO;
import com.persistence.entity.Clientes;
import com.persistence.entity.Empleados;

public class VentaRequest {
	
	private int ventaId;
	private Empleados empleado;
	private Clientes cliente;
	private Date fechaVenta;
	
	private double subtotal;
	private double total;
	
	//lista de los detalles de la venta(producto, cantidad)
	private List<DetalleVentaDTO> detalles;
	
	public VentaRequest() {
		
	}

	public VentaRequest(int ventaId, Empleados empleado, Clientes cliente, Date fechaVenta, double subtotal, double total,
			List<DetalleVentaDTO> detalles) {
		super();
		this.ventaId = ventaId;
		this.empleado = empleado;
		this.cliente = cliente;
		this.fechaVenta = fechaVenta;
		this.subtotal = subtotal;
		this.total = total;
		this.detalles = detalles;
	}

	public List<DetalleVentaDTO> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleVentaDTO> detalles) {
		this.detalles = detalles;
	}

	public int getVentaId() {
		return ventaId;
	}

	public void setVentaId(int ventaId) {
		this.ventaId = ventaId;
	}

	
	public Empleados getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleados empleado) {
		this.empleado = empleado;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "VentaRequest [ventaId=" + ventaId + ", empleado=" + empleado + ", cliente=" + cliente + ", fechaVenta="
				+ fechaVenta + ", subtotal=" + subtotal + ", total=" + total + ", detalles=" + detalles + "]";
	}

	
	
	

}
