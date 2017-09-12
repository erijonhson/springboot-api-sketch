package org.sketch.rest;

import java.util.Collection;

import org.sketch.model.Entidade;
import org.sketch.service.entidade.EntidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Exemplo de classe que mapeia serviços REST para clientes HTTP.
 * 
 * @see 
 * @see <a href=
 *      "https://github.com/ericbreno/projeto-si1-backend/blob/master/src/main/java/ufcg/si/rest/QueixaRest.java">
 *      Inspiração</a>
 * 
 * @author Eri Jonhson
 */
@RestController
@RequestMapping(value = ConstantesRest.ENTIDADE_URI)
@CrossOrigin
public class EntidadeRest {

	@Autowired
	private EntidadeService entidadeService;

	/**
	 * Recurso para cadastrar uma Entidade.
	 * 
	 * @param entidade a ser cadastrada
	 * @return entidade persistida
	 */
	@RequestMapping(value = { "/", "" }, method = RequestMethod.POST)
	public Entidade cadastrarEntidade(@RequestBody Entidade entidade) {
		return entidadeService.cadastrar(entidade);
	}

	/**
	 * Recurso para atualizar uma Entidade específica.
	 * 
	 * @param entidade a ser atualizada
	 * @return entidade atualizada
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Entidade atualizarQueixa(
			@PathVariable Long id, @RequestBody Entidade entidade) {
		entidade.setId(id);
		return entidadeService.atualizar(id, entidade);
	}

	/**
	 * Recurso para consultar todas as Entidades.
	 * 
	 * @return Coleção com todas entidades
	 */
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public Collection<Entidade> consultarQueixas() {
		return entidadeService.buscarTodos();
	}

	/**
	 * Recurso para consultar uma Entidade específica.
	 * 
	 * @param identificador da Entidade
	 * @return entidade encontrada
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Entidade consultarEntidade(@PathVariable Long id) {
		return entidadeService.buscarPorId(id);
	}

}
