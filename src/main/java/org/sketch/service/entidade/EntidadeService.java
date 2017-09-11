package org.sketch.service.entidade;

import org.sketch.model.Entidade;
import org.sketch.service.GenericService;

/**
 * Exemplo de classe que implementa lógica de negócio para determinado contexto
 * no sistema. Aqui serão incluídos quaisquer serviços que esta entidade dependa
 * para adequado funcionamento.
 * 
 * @author Eri Jonhson
 */
public interface EntidadeService extends GenericService<Entidade> {

	public Entidade buscarPorAtributo(String atributo);

}
