package org.server.core.repositories.address;

import org.server.core.entities.address.BillingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingAddressRepository extends JpaRepository<BillingAddress, Long> {

}
