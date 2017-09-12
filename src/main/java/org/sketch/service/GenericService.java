package org.sketch.service;

import java.io.Serializable;
import java.util.Collection;

import org.sketch.exception.ConflictRuntimeException;
import org.sketch.exception.NotFoundRuntimeException;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório de código comum que implementa CRUD básico para ser utilizado em
 * Serviços (classes que implementam lógica de negócio).
 * 
 * @param <T> representa tipo base do serviço implementado
 * @param <ID> representa tipo do identificador da entidade T
 * 
 * @author Eri Jonhson
 */
public abstract class GenericService<T, ID extends Serializable> {

	private static final String CONFLITO = "Erro ao cadastrar ou atualizar %s.";
	private static final String NAO_ENCONTRADA = "%s inexistente(s) ou inválidos(as)!";

	/**
	 * Subclasses devem indicar qual JpaRepository adequado para CRUD básico
	 * fornecido por este repositório de código comum. 
	 * 
	 * @return JpaRepository<T, ID> adequado para CRUD 
	 */
	protected abstract JpaRepository<T, ID> getRepository();

	/**
	 * Subclasses devem personalizar as mensagens de erros que porventura possam
	 * ser lançados, especificando uma String por meio desse método. <br>
	 * <br>
	 * Para {@link ConflictRuntimeException} a mensagem será
	 * <code>"Erro ao cadastrar ou atualizar %s."</code>. <br>
	 * <br>
	 * Para {@link NotFoundRuntimeException} a mensagem será
	 * <code>"%s inexistente(s) ou inválidos(as)!"</code>. Com %s nas mensagens
	 * acima sendo substituídos pelo valor de retorno deste método.
	 * 
	 * @return String para personalizar mensagens de erro.
	 */
	protected abstract String getContexto();

	/**
	 * Persiste entidade no sistema.
	 * 
	 * @exception ConflictRuntimeException caso persistência falhe.
	 * 
	 * @param t entidade a ser persistida
	 * @return <strong>t</strong> entidade após persistência
	 */
	public T cadastrar(T t) {
		try {
			return this.getRepository().save(t);
		} catch (Exception e) {
			throw new ConflictRuntimeException(String.format(CONFLITO, this.getContexto()));
		}
	}

	/**
	 * Atualiza determinada entidade persistida. 
	 * <br>
	 * RestController que utiliza serviços que extendem este repositório de
	 * código comum deve garantir que objeto <strong>t</strong> recebido está
	 * com <strong>id</strong> incluso. 
	 * 
	 * @exception ConflictRuntimeException caso persistência falhe.
	 * 
	 * @param id identificador de entidade a ser atualizada
	 * @param t entidade a ser atualizada
	 * @return <strong>t</strong> entidade após atualização
	 */
	public T atualizar(ID id, T t) {
		if (!this.getRepository().exists(id)) {
			throw new ConflictRuntimeException(String.format(CONFLITO, this.getContexto()));
		}
		return this.cadastrar(t);
	}

	/**
	 * Buscar todas as entidades persistidas.
	 * 
	 * @exception NotFoundRuntimeException caso não encontre nenhuma entidade.
	 * 
	 * @return coleção com entidades persistidas
	 */
	public Collection<T> buscarTodos() {
		Collection<T> t = this.getRepository().findAll();
		if (t == null || t.isEmpty()) {
			throw new NotFoundRuntimeException(String.format(NAO_ENCONTRADA, this.getContexto()));
		}
		return t;
	}

	/**
	 * Buscar uma entidade específica da persistência.
	 * 
	 * @exception NotFoundRuntimeException caso não encontre nenhuma entidade.
	 * 
	 * @param id identificador da entidade a ser buscada
	 * @return <strong>t</strong> entidade encontrada
	 */
	public T buscarPorId(ID id) {
		T t = this.getRepository().findOne(id);
		if (t == null) {
			throw new NotFoundRuntimeException(String.format(NAO_ENCONTRADA, this.getContexto()));
		}
		return t;
	}

	/**
	 * Deletar entidade da persistência.
	 * 
	 * @exception ConflictRuntimeException caso persistência falhe.
	 * 
	 * @param id identificador da entidade a ser deletada
	 */
	public void deletar(ID id) {
		if (!this.getRepository().exists(id)) {
			throw new ConflictRuntimeException(String.format(NAO_ENCONTRADA, this.getContexto()));
		}
		this.getRepository().delete(id);
	}

}
