package com.persistence.request;

import java.sql.Date;

public class ClienteRequest {
	
	private int clienteId;
	private String nombre;
	private Date fechaNac;
	private String domicilio;
	
	public ClienteRequest() {
		
	}

	public ClienteRequest(int clienteId, String nombre, Date fechaNac, String domicilio) {
		super();
		this.clienteId = clienteId;
		this.nombre = nombre;
		this.fechaNac = fechaNac;
		this.domicilio = domicilio;
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

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	@Override
	public String toString() {
		return "ClienteRequest [clienteId=" + clienteId + ", nombre=" + nombre + ", fechaNac=" + fechaNac
				+ ", domicilio=" + domicilio + "]";
	}
	
	
	

}
