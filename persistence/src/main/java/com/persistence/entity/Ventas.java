package com.persistence.entity;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="VENTAS")
public class Ventas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name= "VENTA_ID", columnDefinition="NUMBER")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ventaId;
	
	@ManyToOne
	@JoinColumn(name= "EMPLEADO_ID", columnDefinition="NUMBER")
	//@JsonBackReference
	//@JsonManagedReference
	private Empleados empleado;

	@ManyToOne
	@JoinColumn(name= "CLIENTE_ID", columnDefinition="NUMBER")
	//@JsonBackReference
	//@JsonManagedReference
	private Clientes cliente;
	
	@Column(name= "FECHA_VENTA", columnDefinition="DATE")
	private Date fechaVenta;
	
	@Column(name= "SUBTOTAL", columnDefinition="NUMBER(5,2)")
	private double subtotal;
	
	@Column(name= "TOTAL", columnDefinition="NUMBER(5,2)")
	private double total;
	
	

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
