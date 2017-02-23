package org.realx.core.repositories.secure.keys;

import org.realx.core.entities.secure.keys.SecureKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecureKeyRepository extends JpaRepository<SecureKey, Long> {

}
