package org.server.services.profile.customer;

import org.server.core.entities.profile.customer.RetailCustomerProfile;
import org.server.core.repositories.profile.RetailCustomerProfileRepository;
import org.server.services.abstracts.DefaultJpaServiceImpl;
import org.server.services.abstracts.JpaService;
import org.springframework.stereotype.Service;

@Service
public class RetailCustomerProfileService
		extends DefaultJpaServiceImpl<RetailCustomerProfile, Long, RetailCustomerProfileRepository>
		implements JpaService<RetailCustomerProfile, Long> {

}
