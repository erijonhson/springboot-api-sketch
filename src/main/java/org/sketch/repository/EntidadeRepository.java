package org.sketch.repository;

import java.util.Collection;

import org.sketch.model.Entidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Camada de persistência para Entidade.
 * 
 * @author Eri Jonhson
 */
@Repository(value = "entidadeRepository")
public interface EntidadeRepository extends JpaRepository<Entidade, Long> {

	public Collection<Entidade> findByAtributo(String atributo);

}
