package org.server.services.address;

import org.server.core.entities.address.OfficeAddress;
import org.server.core.repositories.address.OfficeAddressRepository;
import org.server.services.abstracts.DefaultJpaServiceImpl;
import org.server.services.abstracts.JpaService;
import org.springframework.stereotype.Service;

@Service
public class OfficeAddressService extends DefaultJpaServiceImpl<OfficeAddress, Long, OfficeAddressRepository>
		implements JpaService<OfficeAddress, Long> {

}
