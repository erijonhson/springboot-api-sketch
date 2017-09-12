package org.sketch.exception;

/**
 * Agrupa mensagens de erro das exceções do sistema.
 * 
 * @author Eri Jonhson
 */
public class ConstantesDeErro {

	private static final String CONFLITO = "Erro ao cadastrar ou atualizar %s.";
	private static final String NAO_ENCONTRADA = "%s inexistente(s) ou inválidos(as)!";

	public static final String ENTIDADE_CONFLITO = String.format(CONFLITO, "Entidade");
	public static final String ENTIDADE_NAO_ENCONTRADA = String.format(NAO_ENCONTRADA, "Entidade(s)");

	public static final String REMOVIDO = "Serviço inexistente!";

}