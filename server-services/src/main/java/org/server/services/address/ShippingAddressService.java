package org.server.services.address;

import org.server.core.entities.address.ShippingAddress;
import org.server.core.repositories.address.ShippingAddressRepository;
import org.server.services.abstracts.DefaultJpaServiceImpl;
import org.server.services.abstracts.JpaService;
import org.springframework.stereotype.Service;

@Service
public class ShippingAddressService extends DefaultJpaServiceImpl<ShippingAddress, Long, ShippingAddressRepository>
		implements JpaService<ShippingAddress, Long> {

}
