package org.realx.services.secure.keys;

import org.realx.core.entities.secure.keys.SecureKey;
import org.realx.core.repositories.secure.keys.SecureKeyRepository;
import org.realx.services.abstracts.DefaultJpaServiceImpl;
import org.realx.services.abstracts.JpaService;
import org.springframework.stereotype.Service;

@Service
public class SecureKeyService extends DefaultJpaServiceImpl<SecureKey, Long, SecureKeyRepository>
		implements JpaService<SecureKey, Long> {
	public SecureKey expireKey(SecureKey secureKey) {
		secureKey.setKeyNonExpired(false);
		return update(secureKey);
	}
}
