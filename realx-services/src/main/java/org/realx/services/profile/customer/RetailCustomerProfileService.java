package org.realx.services.profile.customer;

import org.realx.core.entities.profile.customer.RetailCustomerProfile;
import org.realx.core.repositories.profile.RetailCustomerProfileRepository;
import org.realx.services.abstracts.DefaultJpaServiceImpl;
import org.realx.services.abstracts.JpaService;
import org.springframework.stereotype.Service;

@Service
public class RetailCustomerProfileService
		extends DefaultJpaServiceImpl<RetailCustomerProfile, Long, RetailCustomerProfileRepository>
		implements JpaService<RetailCustomerProfile, Long> {

}
