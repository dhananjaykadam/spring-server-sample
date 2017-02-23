package org.realx.core.entities.abstracts;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 
 * @author {@link <a href="mailto:jaykadam90@gmail.com">Dhananjay Kadam</a>}
 *
 */
@MappedSuperclass
public abstract class AbstractEntity<T> implements Serializable, IAbstractEntity<T> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected T id;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public T getId() {
		return id;
	}
	@Override
	public void setId(T id) {
		this.id = id;
	}

}
