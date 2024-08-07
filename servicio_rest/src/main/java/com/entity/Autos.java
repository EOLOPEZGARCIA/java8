package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//se uso hibernate un ORM
//HQL HIBERNATE QUERY LANGUAJE

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "modeloId")
@Entity
@Table(name="AUTOS")
public class Autos {    //HIJO
	
	public Autos() {
		
	}
	public Autos(int id) {
		this.modeloId=id;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MODELO_ID",columnDefinition="NUMBER")
	int modeloId;
	
	@Column(name="MODELO",columnDefinition="NVARCHAR2(15)")
	String modelo;
	@Column(name="AÑO",columnDefinition="NUMBER")
	int ano;
	@Column(name="TIPO",columnDefinition="NVARCHAR2(15)")
	String tipo;
	
	@ManyToOne
	@JoinColumn(name="MARCA_ID")
	//@JsonBackReference
	private Marcas marca;
	/*@Column(name="MARCA_ID",columnDefinition="NUMBER")
	int marcaId;
	*/

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
	public int getAno() {
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
	public Marcas getMarca() {
		return marca;
	}
	public void setMarca(Marcas marca) {
		this.marca = marca;
	}
	
	
	
	
}
