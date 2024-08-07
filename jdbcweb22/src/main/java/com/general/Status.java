package com.general;

public class Status {
	
	String mensaje,respuesta;
	Object ob;
	
	public Status() {
		
	}
	public Status(String mensaje, String respuesta, Object ob) {
		super();
		this.mensaje = mensaje;
		this.respuesta = respuesta;
		this.ob = ob;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public Object getOb() {
		return ob;
	}
	public void setOb(Object ob) {
		this.ob = ob;
	}
	

}
