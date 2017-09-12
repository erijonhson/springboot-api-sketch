package org.sketch.service.entidade;

import java.util.Collection;

import org.sketch.exception.ConstantesDeErro;
import org.sketch.exception.GoneRuntimeException;
import org.sketch.exception.NotFoundRuntimeException;
import org.sketch.model.Entidade;
import org.sketch.repository.EntidadeRepository;
import org.sketch.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Possível implementação para {@link EntidadeService} proposta.
 * 
 * @author Eri Jonhson
 */
@Service(value = "entidadeService")
public class EntidadeServiceImpl extends GenericService<Entidade, Long> implements EntidadeService {

	private static final String contexto = "Entidade(s)";

	@Autowired
	EntidadeRepository entidadeRepository;

	@Override
	protected JpaRepository<Entidade, Long> getRepository() {
		return this.entidadeRepository;
	}

	@Override
	protected String getContexto() {
		return contexto;
	}

	/**
	 * Exemplo de serviço que não é especificado na interface, mas o repositório
	 * de código comum tem uma implementação válida. Nesse caso, é possível
	 * avisar ao cliente para não deve ser chamá-lo novamente.
	 * 
	 * @exception GoneRuntimeException
	 */
	@Override
	public void deletar(Long id) {
		throw new GoneRuntimeException(ConstantesDeErro.REMOVIDO);
	}

	@Override
	public Collection<Entidade> buscarPorAtributo(String atributo) {
		Collection<Entidade> entidades = entidadeRepository.findByAtributo(atributo);
		if (entidades == null || entidades.isEmpty()) {
			throw new NotFoundRuntimeException(ConstantesDeErro.ENTIDADE_NAO_ENCONTRADA);
		}
		return entidades;
	}

}
