package com.persistence.request;

import java.sql.Date;

public class EmpleadoRequest {

	private int empleadoId;
	private String nombre;
	private Date fechaIngreso;
	private int salario;
	
	public EmpleadoRequest() {
	
	}

	public EmpleadoRequest(int empleadoId, String nombre, Date fechaIngreso, int salario) {
		super();
		this.empleadoId = empleadoId;
		this.nombre = nombre;
		this.fechaIngreso = fechaIngreso;
		this.salario = salario;
	}

	public int getEmpleadoId() {
		return empleadoId;
	}

	public void setEmpleadoId(int empleadoId) {
		this.empleadoId = empleadoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "EmpleadoRequest [empleadoId=" + empleadoId + ", nombre=" + nombre + ", fechaIngreso=" + fechaIngreso
				+ ", salario=" + salario + "]";
	}
	
	

}
