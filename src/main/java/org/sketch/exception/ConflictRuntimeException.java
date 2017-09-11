package org.sketch.exception;

/**
 * Representa algum Conflito (HTTP 409).
 * 
 * @author Eri Jonhson
 */
public class ConflictRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -7282249138320312329L;

	public ConflictRuntimeException(String message) {
		super(message);
	}

}
