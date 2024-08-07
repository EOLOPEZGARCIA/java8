package com.msautos.request;


public class AutoRequest {
	
	private int modeloId;
	private String modelo;
	private int ano;
	private String tipo;
	private int marcaId;
	
	public AutoRequest() {
		
	}

	public AutoRequest(int modeloId, String modelo, int ano, String tipo, int marcaId) {
		super();
		this.modeloId = modeloId;
		this.modelo = modelo;
		this.ano = ano;
		this.tipo = tipo;
		this.marcaId = marcaId;
	}

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

	public int getMarcaId() {
		return marcaId;
	}

	public void setMarcaId(int marcaId) {
		this.marcaId = marcaId;
	}

	@Override
	public String toString() {
		return "AutoRequest [modeloId=" + modeloId + ", modelo=" + modelo + ", ano=" + ano + ", tipo=" + tipo
				+ ", marcaId=" + marcaId + "]";
	}
	
	
	
	
	
}
