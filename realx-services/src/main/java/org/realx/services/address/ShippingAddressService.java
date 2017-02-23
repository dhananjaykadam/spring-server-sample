package org.realx.services.address;

import org.realx.core.entities.address.ShippingAddress;
import org.realx.core.repositories.address.ShippingAddressRepository;
import org.realx.services.abstracts.DefaultJpaServiceImpl;
import org.realx.services.abstracts.JpaService;
import org.springframework.stereotype.Service;

@Service
public class ShippingAddressService extends DefaultJpaServiceImpl<ShippingAddress, Long, ShippingAddressRepository>
		implements JpaService<ShippingAddress, Long> {

}
