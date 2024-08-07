package com.msautos.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="AUTOS")
public class Autos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name= "MODELO_ID", columnDefinition="NUMBER")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int modeloId;
	
	@Column(name= "MODELO", columnDefinition="NVARCHAR(15)")
	private String modelo;
	
	@Column(name= "AÑO", columnDefinition="NUMBER")
	private int ano;
	
	@Column(name= "TIPO", columnDefinition="NVARCHAR(15)")
	private String tipo;
	
	@Column(name= "MARCA_ID", columnDefinition="NUMBER")
	private int marcaId;

	public int getModeloId() {
		return modeloId;
	}

	public void setModeloId(int modeloId) {
		this.modeloId = modeloId;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public int getMarcaId() {
		return marcaId;
	}

	public void setMarcaId(int marcaId) {
		this.marcaId = marcaId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
