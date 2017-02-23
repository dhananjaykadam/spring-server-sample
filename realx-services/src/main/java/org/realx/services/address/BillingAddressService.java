package org.realx.services.address;

import org.realx.core.entities.address.BillingAddress;
import org.realx.core.repositories.address.BillingAddressRepository;
import org.realx.services.abstracts.DefaultJpaServiceImpl;
import org.realx.services.abstracts.JpaService;
import org.springframework.stereotype.Service;
@Service
public class BillingAddressService extends DefaultJpaServiceImpl<BillingAddress,  Long,BillingAddressRepository>
		implements JpaService<BillingAddress, Long> {

}
