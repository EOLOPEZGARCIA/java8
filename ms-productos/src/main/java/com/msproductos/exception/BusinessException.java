package com.msproductos.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	String mensaje;

	public BusinessException() {
		super();
	}

	public BusinessException(String message) {
		this.mensaje = message;
	}

	@Override
	public String getMessage() {
		return this.mensaje;
	}

}
