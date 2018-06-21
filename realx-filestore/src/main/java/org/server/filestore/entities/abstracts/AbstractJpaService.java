package org.server.filestore.entities.abstracts;

/**
 * 
 * @author {@link <a href="mailto:jaykadam90@gmail.com">Dhananjay Kadam</a>}
 *
 * @param <T>
 */
public interface AbstractJpaService<T> {
	public T create(T entity);

	public T update(T entity);

	public void delete(T entity);

	public T findById(Long id);
}
