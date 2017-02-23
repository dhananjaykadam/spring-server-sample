package org.realx.services.abstracts;

/**
 * 
 * @author {@link <a href="mailto:jaykadam90@gmail.com">Dhananjay Kadam</a>}
 *
 * @param <T>
 */
public interface JpaService<T /* extends VersionableEntity */, K> {

	public T create(T entity);

	public T update(T entity);

	// public default void delete(T entity) {
	// entity.setDeleted_at(new Date());
	// update(entity);
	// }
	public void delete(T entity);

	public T findById(K id);
}
