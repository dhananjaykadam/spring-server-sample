package org.realx.core.repositories.secure.keys;

import org.realx.core.entities.secure.keys.SecureEmailResetKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecureEmailResetKeyRepository extends JpaRepository<SecureEmailResetKey, Long> {
	public SecureEmailResetKey findBySecureKeyKeyContentAndSecureKeyKeyNonExpired(String key, Boolean keyNonExpired);
}
