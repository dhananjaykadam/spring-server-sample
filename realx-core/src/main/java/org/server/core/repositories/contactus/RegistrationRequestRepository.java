package org.server.core.repositories.contactus;

import org.server.core.entities.contactus.RegistrationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRequestRepository extends JpaRepository<RegistrationRequest, Long> {

}
