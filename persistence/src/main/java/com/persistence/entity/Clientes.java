package com.persistence.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="CUSTOMERS")
public class Clientes implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name= "CLIENTE_ID", columnDefinition="NUMBER")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int clienteId;
	
	@Column(name= "NOMBRE", columnDefinition="NVARCHAR(15)")
	private String nombre;
	
	@Column(name= "FECHA_NAC", columnDefinition="DATE")
	private Date fechaNac;
	
	@Column(name= "DOMICILIO", columnDefinition="NVARCHAR(40)")
	private String domicilio;

	//atributo relacional
	@OneToMany(mappedBy="cliente")
	//@JsonManagedReference
	@JsonBackReference(value="id")
	private List<Ventas> ventas;
	
	public List<Ventas> getVentas() {
		return ventas;
	}

	public void setVentas(List<Ventas> ventas) {
		this.ventas = ventas;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
