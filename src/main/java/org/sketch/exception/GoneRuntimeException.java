package org.sketch.exception;

/**
 * Indica que recurso nunca estará disponível (HTTP 410).
 * 
 * @author Eri Jonhson
 */
public class GoneRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 759124636219888805L;

	public GoneRuntimeException(String message) {
		super(message);
	}

}
