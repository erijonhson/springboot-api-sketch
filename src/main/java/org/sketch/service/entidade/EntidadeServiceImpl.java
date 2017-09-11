package org.sketch.service.entidade;

import java.util.Collection;

import org.sketch.exception.ConflictRuntimeException;
import org.sketch.exception.ConstantesDeErro;
import org.sketch.exception.GoneRuntimeException;
import org.sketch.exception.NotFoundRuntimeException;
import org.sketch.model.Entidade;
import org.sketch.repository.EntidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "entidadeService")
public class EntidadeServiceImpl implements EntidadeService {

	@Autowired
	EntidadeRepository entidadeRepository;

	@Override
	public Entidade cadastrar(Entidade entidade) {
		try {
			return entidadeRepository.save(entidade);
		} catch (Exception e) {
			throw new ConflictRuntimeException(ConstantesDeErro.ENTIDADE_CONFLITO);
		}
	}

	@Override
	public Entidade atualizar(Long id, Entidade entidade) {
		if (!entidadeRepository.exists(id)) {
			throw new ConflictRuntimeException(ConstantesDeErro.ENTIDADE_NAO_ENCONTRADA);
		}
		entidade.setId(id);
		return this.cadastrar(entidade);
	}

	@Override
	public Collection<Entidade> buscarTodos() {
		Collection<Entidade> entidades = entidadeRepository.findAll();
		if (entidades == null || entidades.isEmpty()) {
			throw new NotFoundRuntimeException(ConstantesDeErro.ENTIDADE_NAO_ENCONTRADA);
		}
		return entidades;
	}

	@Override
	public Entidade buscarPorId(Long id) {
		Entidade entidade = entidadeRepository.findOne(id);
		return verifyNotFound(entidade);
	}

	/**
	 * Exemplo de serviço que não deve ser chamado novamente pelo cliente. 
	 * 
	 * @exception GoneRuntimeException
	 */
	@Override
	public void deletar(Long id) {
		throw new GoneRuntimeException(ConstantesDeErro.REMOVIDO);
	}

	@Override
	public Entidade buscarPorAtributo(String atributo) {
		Entidade entidade = entidadeRepository.findByAtributo(atributo);
		return verifyNotFound(entidade);
	}

	private Entidade verifyNotFound(Entidade entidade) {
		if (entidade == null) {
			throw new NotFoundRuntimeException(ConstantesDeErro.ENTIDADE_NAO_ENCONTRADA);
		}
		return entidade;
	}

}
