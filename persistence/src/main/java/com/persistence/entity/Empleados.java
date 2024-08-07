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
@Table(name="EMPLEADOS")
public class Empleados implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name= "EMPLEADO_ID", columnDefinition="NUMBER")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empleadoId;
	
	@Column(name= "NOMBRE", columnDefinition="NVARCHAR(15)")
	private String nombre;
	
	@Column(name= "FECHA_INGRESO", columnDefinition="DATE")
	private Date fechaIngreso;
	
	@Column(name= "SALARIO", columnDefinition="NUMBER(5,2)")
	private int salario;
	@OneToMany(mappedBy="empleado")
	@JsonBackReference(value="id")
	//@JsonManagedReference
	private List<Ventas> ventas;
	
	
	public List<Ventas> getVentas() {
		return ventas;
	}

	public void setVentas(List<Ventas> ventas) {
		this.ventas = ventas;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
