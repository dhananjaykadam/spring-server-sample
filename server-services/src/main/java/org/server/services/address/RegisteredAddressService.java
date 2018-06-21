package org.server.services.address;

import org.server.core.entities.address.RegisteredAddress;
import org.server.core.repositories.address.RegisteredAddressRepository;
import org.server.services.abstracts.DefaultJpaServiceImpl;
import org.server.services.abstracts.JpaService;
import org.springframework.stereotype.Service;

@Service
public class RegisteredAddressService
		extends DefaultJpaServiceImpl<RegisteredAddress, Long, RegisteredAddressRepository>
		implements JpaService<RegisteredAddress, Long> {

}
