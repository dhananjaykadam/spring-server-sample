package org.realx.services.contactus;

import org.realx.core.entities.contactus.RegistrationRequest;
import org.realx.core.repositories.contactus.RegistrationRequestRepository;
import org.realx.services.abstracts.DefaultJpaServiceImpl;
import org.realx.services.abstracts.JpaService;
import org.springframework.stereotype.Service;

@Service
public class RegistrationRequestService
		extends DefaultJpaServiceImpl<RegistrationRequest, Long, RegistrationRequestRepository>
		implements JpaService<RegistrationRequest, Long> {

}
