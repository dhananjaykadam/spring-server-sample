package org.realx.services.address;

import org.realx.core.entities.address.OfficeAddress;
import org.realx.core.repositories.address.OfficeAddressRepository;
import org.realx.services.abstracts.DefaultJpaServiceImpl;
import org.realx.services.abstracts.JpaService;
import org.springframework.stereotype.Service;

@Service
public class OfficeAddressService extends DefaultJpaServiceImpl<OfficeAddress, Long, OfficeAddressRepository>
		implements JpaService<OfficeAddress, Long> {

}
