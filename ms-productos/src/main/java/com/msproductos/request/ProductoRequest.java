package com.msproductos.request;

import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
//import jakarta.validation.constraints.;


public class ProductoRequest {
	
	private int productoId;
	private int deptoId;
		
	@NotBlank(message="EL nombre no puede queadar nulo ni vacio")
	@Size(min=5, max=20)
	private String nombre;
	
	Integer a = new Integer(3);
	Integer b = new Integer(3);
	
	if(a==b) {
		
	}
	@FutureOrPresent(message="La caducidad debe ser una fecha del futuro")
	private LocalDate fecha;
	
	@DecimalMax(value="999.99")
	private double precioCompra;
	@DecimalMax(value="999.99")
	private double precioVenta;
	
	
	private String refrigerado;
	
	// dar una forma a los objetos que vienen de postman
	public ProductoRequest() {
		
	}

	public ProductoRequest(int productoId, int deptoId, String nombre, LocalDate fecha, double precioCompra,
			double precioVenta, String refrigerado) {
		super();
		this.productoId = productoId;
		this.deptoId = deptoId;
		this.nombre = nombre;
		this.fecha = fecha;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.refrigerado = refrigerado;
	}

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

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public String getRefrigerado() {
		return refrigerado;
	}

	public void setRefrigerado(String refrigerado) {
		this.refrigerado = refrigerado;
	}

	@Override
	public String toString() {
		return "ProductoRequest [productoId=" + productoId + ", deptoId=" + deptoId + ", nombre=" + nombre + ", fecha="
				+ fecha + ", precioCompra=" + precioCompra + ", precioVenta=" + precioVenta + ", refrigerado="
				+ refrigerado + "]";
	}
	
	
	
	
	


}
