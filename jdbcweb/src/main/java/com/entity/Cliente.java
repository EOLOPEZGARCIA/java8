package com.entity;

import java.sql.Date;

//POJO Plain Old Java Object
//Entidad modelo que mapea fisicamente a una tabla de datos
public class Cliente {
	
	private int clienteId;
	private String nombre;
	private String rfc;
	private String direccion;
	private String correo;
	private String telefono;
	private Date fechaNac;
	
	public Cliente(){}

	public Cliente(int clienteId, String nombre, String rfc, String direccion, String correo, String telefono,
			Date fechaNac) {
		super();
		this.clienteId = clienteId;
		this.nombre = nombre;
		this.rfc = rfc;
		this.direccion = direccion;
		this.correo = correo;
		this.telefono = telefono;
		this.fechaNac = fechaNac;
	}

	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	@Override
	public String toString() {
		return "Cliente [clienteId=" + clienteId + ", nombre=" + nombre + ", rfc=" + rfc + ", direccion=" + direccion
				+ ", correo=" + correo + ", telefono=" + telefono + ", fechaNac=" + fechaNac + "]";
	}
	
	
}
