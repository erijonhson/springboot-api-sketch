package org.sketch.service.entidade;

import java.util.Collection;

import org.sketch.exception.ConflictRuntimeException;
import org.sketch.exception.NotFoundRuntimeException;
import org.sketch.model.Entidade;
import org.sketch.service.GenericService;

/**
 * Exemplo de interface de lógica de negócio para determinado contexto no
 * sistema. <br>
 * <br>
 * As implementações desta classe devem compor quaisquer objetos necessários à
 * lógica de negócios. Ou seja, cabe ao RestController associado apenas delegar
 * para algum método aqui definido e a implementação deste método deve garantir
 * resolução e resposta válida ou lançar exceção para o ControllerAdvice.
 * 
 * @author Eri Jonhson
 */
public interface EntidadeService {

	/**
	 * Persiste entidade no sistema. 
	 * 
	 * @see GenericService
	 * 
	 * @exception ConflictRuntimeException caso persistência falhe.
	 * 
	 * @param entidade a ser persistida
	 * @return entidade após persistência
	 */
	public Entidade cadastrar(Entidade entidade);

	/**
	 * Atualiza determinada entidade persistida.
	 * 
	 * @see GenericService
	 * 
	 * @exception ConflictRuntimeException caso persistência falhe.
	 * 
	 * @param id identificador de entidade a ser atualizada
	 * @param entidade a ser atualizada
	 * @return entidade após atualização
	 */
	public Entidade atualizar(Long id, Entidade entidade);

	/**
	 * Buscar todas as entidades persistidas.
	 * 
	 * @see GenericService
	 * 
	 * @exception NotFoundRuntimeException caso não encontre nenhuma entidade.
	 * 
	 * @return coleção com entidades persistidas
	 */
	public Collection<Entidade> buscarTodos();

	/**
	 * Buscar uma entidade específica da persistência.
	 * 
	 * @see GenericService
	 * 
	 * @exception NotFoundRuntimeException caso não encontre nenhuma entidade.
	 * 
	 * @param id identificador da entidade a ser buscada
	 * @return entidade encontrada
	 */
	public Entidade buscarPorId(Long id);

	/**
	 * Buscar todas as entidades com mesmo atributo. 
	 * 
	 * @param atributo com o qual entidades serão pesquisadas 
	 * @return entidades encontradas
	 */
	public Collection<Entidade> buscarPorAtributo(String atributo);

}
