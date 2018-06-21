package org.server.services.address;

import org.server.core.entities.address.BillingAddress;
import org.server.core.repositories.address.BillingAddressRepository;
import org.server.services.abstracts.DefaultJpaServiceImpl;
import org.server.services.abstracts.JpaService;
import org.springframework.stereotype.Service;
@Service
public class BillingAddressService extends DefaultJpaServiceImpl<BillingAddress,  Long,BillingAddressRepository>
		implements JpaService<BillingAddress, Long> {

}
