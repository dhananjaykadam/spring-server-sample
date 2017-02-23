package org.realx.services.profile.customer;

import org.realx.core.entities.profile.customer.CorporateCustomerProfile;
import org.realx.core.repositories.profile.CorporateCustomerProfileRepository;
import org.realx.services.abstracts.DefaultJpaServiceImpl;
import org.realx.services.abstracts.JpaService;
import org.springframework.stereotype.Service;

@Service
public class CorporateCustomerProfileService
		extends DefaultJpaServiceImpl<CorporateCustomerProfile, Long, CorporateCustomerProfileRepository>
		implements JpaService<CorporateCustomerProfile, Long> {

}
