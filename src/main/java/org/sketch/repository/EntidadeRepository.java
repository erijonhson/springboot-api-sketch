package org.sketch.repository;

import org.sketch.model.Entidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "entidadeRepository")
public interface EntidadeRepository extends JpaRepository<Entidade, Long> {

	public Entidade findByAtributo(String atributo);

}
