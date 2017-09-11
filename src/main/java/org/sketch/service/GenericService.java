package org.sketch.service;

import java.util.Collection;

import org.sketch.exception.ConflictRuntimeException;
import org.sketch.exception.NotFoundRuntimeException;

/**
 * Interface para Serviços (classes que implementam lógica de negócio).
 * 
 * @author Eri Jonhson
 * @param <T> identifica contexto do serviço implementado
 */
public interface GenericService<T> {

	/**
	 * Persiste entidade no sistema. 
	 * 
	 * @exception ConflictRuntimeException
	 * 
	 * @param entidade a ser persistida
	 * @return entidade após persistência
	 */
	public T cadastrar(T t);

	/**
	 * Atualiza determinada entidade persistida.
	 * 
	 * @exception ConflictRuntimeException
	 * 
	 * @param identificador de entidade a ser atualizada
	 * @param entidade a ser atualizada
	 * @return entidade após atualização
	 */
	public T atualizar(Long id, T t);

	/**
	 * Buscar todas as entidades persistidas.
	 * 
	 * @exception NotFoundRuntimeException
	 * 
	 * @return coleção com entidades persistidas
	 */
	public Collection<T> buscarTodos();

	/**
	 * Buscar uma entidade específica da persistência.
	 * 
	 * @exception NotFoundRuntimeException
	 * 
	 * @param identificador da entidade a ser buscada
	 * @return entidade encontrada
	 */
	public T buscarPorId(Long id);

	/**
	 * Deletar tupla da persistência.
	 * 
	 * @exception ConflictRuntimeException
	 * 
	 * @param identificador da entidade a ser deletada
	 */
	public void deletar(Long id);

}
