package org.server.core.repositories.common;

import org.server.core.entities.appconfig.AppConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author {@link <a href="mailto:jaykadam90@gmail.com">Dhananjay Kadam</a>}
 *
 */
@Repository
public interface AppConfigRepository extends JpaRepository<AppConfig, Long> {
	public AppConfig findByMetaKey(String key);
}
