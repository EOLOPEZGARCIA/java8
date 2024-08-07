package com.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



@Entity
@Table(name="MARCAS")
@JsonSerialize(as= Marcas.class)
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "marcaId")
public class Marcas { //PADRE
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MARCA_ID",columnDefinition="NUMBER")
	int marcaId;
	
	@Column(name="NOMBRE",columnDefinition="NVARCHAR2(15)")
	String nombre;
	@Column(name="CEO",columnDefinition="NVARCHAR2(30)")
	String ceo;
	@Column(name="PAIS_ID",columnDefinition="NUMBER")
	int paisId;
	
	
	//Atributo relacional
	@OneToMany(mappedBy ="marca")
	//@JsonManagedReference
	private List<Autos> autos;

	public int getMarcaId() {
		return marcaId;
	}

	public void setMarcaId(int marcaId) {
		this.marcaId = marcaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public int getPaisId() {
		return paisId;
	}

	public void setPaisId(int paisId) {
		this.paisId = paisId;
	}

	public List<Autos> getAutos() {
		return autos;
	}

	public void setAutos(List<Autos> autos) {
		this.autos = autos;
	}

}
