package org.server.services.abstracts;

import java.io.Serializable;
import java.util.Date;

import org.server.core.entities.abstracts.IVersionableEntity;
import org.server.core.entities.user.User;
import org.server.services.user.UserService;
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
public abstract class DefaultJpaServiceImpl<T extends IVersionableEntity<K>, K extends Serializable, Repository extends JpaRepository<T, K>>
		implements JpaService<T, K> {

	@Autowired
	private Repository repository;
	@Autowired
	private UserService userService;

	@Override
	public T create(T entity) {
		// TODO Auto-generated method stub
		entity.setCreatedBy(userService.getLoggedInUser());
		return repository.saveAndFlush(entity);
	}

	@Override
	public T update(T entity) {
		/**
		 * Prevent createdBy from modification
		 */
		if (entity.getId() != null) {
			T entitydb = repository.findOne(entity.getId());
			if (entitydb != null) {
				User createdBy = entitydb.getCreatedBy();
				entity.setCreatedBy(createdBy);
			} else {
				entity.setCreatedBy(userService.getLoggedInUser());
			}
		} else {
			entity.setCreatedBy(userService.getLoggedInUser());
		}
		entity.setUpdatedBy(userService.getLoggedInUser());
		return repository.save(entity);
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		if (entity.getDeletedAt() != null) {
			return;
		}
		entity.setDeletedAt(new Date());
		update(entity);
	}

	@Override
	public T findById(K id) {
		// TODO Auto-generated method stub
		return repository.findOne(id);
	}

}
