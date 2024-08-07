package com.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="PRODUCTOS")
public class Productos {
	
	
	public Productos() {
		
	}

	public Productos(int id) {
		
		this.productoId = id;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRODUCTO_ID",columnDefinition="NUMBER")
	int productoId;
	
	@Column(name="DEPTO_ID",columnDefinition="NUMBER")
	int deptoId;
	@Column(name="NOMBRE",columnDefinition="NVARCHAR2(20)")
	String nombre;
	@Column(name="FECHA_CAD",columnDefinition="DATE")
	Date fechaCad;
	@Column(name="PRECIO_COMPRA",columnDefinition="NUMBER(5,2)")
	float precioCompra;
	@Column(name="PRECIO_VENTA",columnDefinition="NUMBER(5,2)")
	float precioVenta;
	@Column(name="REFRIGERADO",columnDefinition="CHAR(1)")
	char refri;
	
	@OneToOne(mappedBy = "producto", cascade = CascadeType.ALL)
	@JsonManagedReference
    private Inventarios inventario;

	public int getProductoId() {
		return productoId;
	}

	public void setProductoId(int productoId) {
		this.productoId = productoId;
	}

	public int getDeptoId() {
		return deptoId;
	}

	public void setDeptoId(int deptoId) {
		this.deptoId = deptoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaCad() {
		return fechaCad;
	}

	public void setFechaCad(Date fechaCad) {
		this.fechaCad = fechaCad;
	}

	public float getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(float precioCompra) {
		this.precioCompra = precioCompra;
	}

	public float getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}

	public char getRefri() {
		return refri;
	}

	public void setRefri(char refri) {
		this.refri = refri;
	}

	public Inventarios getInventario() {
		return inventario;
	}

	public void setInventario(Inventarios inventario) {
		this.inventario = inventario;
	}
	
	

}
