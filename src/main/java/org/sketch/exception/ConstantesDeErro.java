package org.sketch.exception;

/**
 * Agrupa mensagens de erro das exceções do sistema.
 * 
 * @author Eri Jonhson
 */
public class ConstantesDeErro {

	private static final String CONFLITO = "Erro ao cadastrar ou atualizar %s.";
	// private static final String NAO_ENCONTRADO = "%s inexistente(s) ou inválido(s)!";
	private static final String NAO_ENCONTRADA = "%s inexistente(s) ou inválida(s)!";

	public static final String ENTIDADE_CONFLITO = String.format(CONFLITO, "Entidade");
	public static final String ENTIDADE_NAO_ENCONTRADA = String.format(NAO_ENCONTRADA, "Entidade(s)");

	public static final String REMOVIDO = "Serviço inexistente!";

}
