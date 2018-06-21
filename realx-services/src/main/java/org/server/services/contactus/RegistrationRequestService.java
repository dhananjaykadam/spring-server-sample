package org.server.services.contactus;

import org.server.core.entities.contactus.RegistrationRequest;
import org.server.core.repositories.contactus.RegistrationRequestRepository;
import org.server.services.abstracts.DefaultJpaServiceImpl;
import org.server.services.abstracts.JpaService;
import org.springframework.stereotype.Service;

@Service
public class RegistrationRequestService
		extends DefaultJpaServiceImpl<RegistrationRequest, Long, RegistrationRequestRepository>
		implements JpaService<RegistrationRequest, Long> {

}
