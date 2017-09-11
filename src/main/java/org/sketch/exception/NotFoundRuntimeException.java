package org.sketch.exception;

/**
 * Indica que não encontrou resultado de alguma consulta ao Banco de Dados 
 * (HTTP 404).
 * 
 * @author Eri Jonhson
 */
public class NotFoundRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -6221193559753533505L;

	public NotFoundRuntimeException(String message) {
		super(message);
	}

}
