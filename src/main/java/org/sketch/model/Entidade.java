package org.sketch.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Exemplo de entidade do domínio. 
 * 
 * @author Eri Jonhson
 */
@Entity
public class Entidade implements Serializable {

	private static final long serialVersionUID = -6594605967586798336L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "atributo")
	private String atributo;

	public Entidade() {
		this("Desconhecido");
	}

	public Entidade(String atributo) {
		this.setAtributo(atributo);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAtributo() {
		return atributo;
	}

	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atributo == null) ? 0 : atributo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entidade other = (Entidade) obj;
		if (atributo == null) {
			if (other.atributo != null)
				return false;
		} else if (!atributo.equals(other.atributo))
			return false;
		return true;
	}

}
