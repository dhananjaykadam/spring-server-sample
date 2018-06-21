package org.server.core.repositories.user;

import java.util.List;

import org.server.core.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author {@link <a href="mailto:jaykadam90@gmail.com">Dhananjay Kadam</a>}
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public List<User> findByUsernameAndPassword(String username, String password);

	public User findByUsername(String username);
	
}
