package org.server.services.profile.customer;

import org.server.core.entities.profile.customer.CorporateCustomerProfile;
import org.server.core.repositories.profile.CorporateCustomerProfileRepository;
import org.server.services.abstracts.DefaultJpaServiceImpl;
import org.server.services.abstracts.JpaService;
import org.springframework.stereotype.Service;

@Service
public class CorporateCustomerProfileService
		extends DefaultJpaServiceImpl<CorporateCustomerProfile, Long, CorporateCustomerProfileRepository>
		implements JpaService<CorporateCustomerProfile, Long> {

}
