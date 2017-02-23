package org.realx.core.repositories.profile;

import org.realx.core.entities.profile.common.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ContactInfoRepository extends JpaRepository<ContactInfo, Long> {

}
