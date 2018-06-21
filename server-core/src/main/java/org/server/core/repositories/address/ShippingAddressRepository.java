package org.server.core.repositories.address;

import org.server.core.entities.address.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, Long> {

}
