package org.server.security.abstracts;

import java.util.Date;

import org.server.core.entities.abstracts.VersionableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Default implementation for {@link JpaService} interface
 * 
 * @author {@link <a href="mailto:jaykadam90@gmail.com">Dhananjay Kadam</a>}
 *
 * @param <T>
 * @param <Repository>
 */
public abstract class DefaultSecurityJpaServiceImpl<T extends VersionableEntity, Repository extends JpaRepository<T, Long>>
		implements SecurityJpaService<T> {

	@Autowired
	private Repository repository;

	@Override
	public T create(T entity) {
		// TODO Auto-generated method stub
		return repository.saveAndFlush(entity);
	}

	@Override
	public T update(T entity) {
		// TODO Auto-generated method stub
		return repository.save(entity);
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		entity.setDeletedAt(new Date());
		update(entity);
	}

	@Override
	public T findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findOne(id);
	}

}
