package org.server.services.appconfig;

import org.server.core.entities.appconfig.AppConfig;
import org.server.core.repositories.common.AppConfigRepository;
import org.server.services.abstracts.DefaultJpaServiceImpl;
import org.server.services.abstracts.JpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author {@link <a href="mailto:jaykadam90@gmail.com">Dhananjay Kadam</a>}
 *
 */
@Service
public class AppConfigService extends DefaultJpaServiceImpl<AppConfig, Long, AppConfigRepository> implements JpaService<AppConfig, Long> {

	@Autowired
	private AppConfigRepository globalConfigRepository;

	public AppConfigRepository getGlobalConfigRepository() {
		return globalConfigRepository;
	}

	public void setGlobalConfigRepository(AppConfigRepository globalConfigRepository) {
		this.globalConfigRepository = globalConfigRepository;
	}

	public AppConfig findByMetaKey(String key) {
		return getGlobalConfigRepository().findByMetaKey(key);
	}
}
