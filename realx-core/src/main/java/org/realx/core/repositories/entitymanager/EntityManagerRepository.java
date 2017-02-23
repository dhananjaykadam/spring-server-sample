package org.realx.core.repositories.entitymanager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class EntityManagerRepository {
	@PersistenceContext
	private EntityManager entityManager;

	public <T> T detachEntity(T u) {
		entityManager.detach(u);
		return u;
	}
}
