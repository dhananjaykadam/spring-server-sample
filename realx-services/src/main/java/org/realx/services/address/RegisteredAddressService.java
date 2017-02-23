package org.realx.services.address;

import org.realx.core.entities.address.RegisteredAddress;
import org.realx.core.repositories.address.RegisteredAddressRepository;
import org.realx.services.abstracts.DefaultJpaServiceImpl;
import org.realx.services.abstracts.JpaService;
import org.springframework.stereotype.Service;

@Service
public class RegisteredAddressService
		extends DefaultJpaServiceImpl<RegisteredAddress, Long, RegisteredAddressRepository>
		implements JpaService<RegisteredAddress, Long> {

}
