package org.server.core.repositories.profile;

import org.server.core.entities.profile.common.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ContactInfoRepository extends JpaRepository<ContactInfo, Long> {

}
