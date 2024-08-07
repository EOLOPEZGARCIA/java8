package com.entity;

//POJO Plain Old Java Object
//Entidad modelo que mapea fisicamente a una tabla de datos
public class Cuenta {
	
	private int cuentaId;
	private String clabe;
	private double saldo;
	private String numCuenta;
	private int tipoId;
	private int clienteId;
	
	public Cuenta(){}

	public Cuenta(int cuentaId, String clabe, double saldo, String numCuenta, int tipoId, int clienteId) {
		super();
		this.cuentaId = cuentaId;
		this.clabe = clabe;
		this.saldo = saldo;
		this.numCuenta = numCuenta;
		this.tipoId = tipoId;
		this.clienteId = clienteId;
	}

	public int getCuentaId() {
		return cuentaId;
	}

	public void setCuentaId(int cuentaId) {
		this.cuentaId = cuentaId;
	}

	public String getClabe() {
		return clabe;
	}

	public void setClabe(String clabe) {
		this.clabe = clabe;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	public int getTipoId() {
		return tipoId;
	}

	public void setTipoId(int tipoId) {
		this.tipoId = tipoId;
	}

	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

	@Override
	public String toString() {
		return "Cuenta [cuentaId=" + cuentaId + ", clabe=" + clabe + ", saldo=" + saldo + ", numCuenta=" + numCuenta
				+ ", tipoId=" + tipoId + ", clienteId=" + clienteId + "]";
	}
	
	
}
