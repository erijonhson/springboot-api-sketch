package org.sketch.exception;

import java.io.Serializable;

/**
 * Objeto de Erro é entregue ao cliente no corpo da resposta sempre que uma
 * Exceção for lançada e não tratada. Por motivos de KISS, há apenas o atributo
 * <strong>causa</strong> nesta classe.
 * 
 * @author Eri Jonhson
 */
public class Erro implements Serializable {

	private static final long serialVersionUID = -2151699914472166002L;

	private String causa;

	public Erro(String causa) {
		this.setCausa(causa);
	}

	public String getCausa() {
		return causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}

}
