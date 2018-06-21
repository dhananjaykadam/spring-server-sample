package org.server.services.secure.keys;

import org.server.core.entities.secure.keys.SecureKey;
import org.server.core.repositories.secure.keys.SecureKeyRepository;
import org.server.services.abstracts.DefaultJpaServiceImpl;
import org.server.services.abstracts.JpaService;
import org.springframework.stereotype.Service;

@Service
public class SecureKeyService extends DefaultJpaServiceImpl<SecureKey, Long, SecureKeyRepository>
		implements JpaService<SecureKey, Long> {
	public SecureKey expireKey(SecureKey secureKey) {
		secureKey.setKeyNonExpired(false);
		return update(secureKey);
	}
}
