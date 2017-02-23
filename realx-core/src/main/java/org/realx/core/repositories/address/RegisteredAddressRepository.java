package org.realx.core.repositories.address;

import org.realx.core.entities.address.RegisteredAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisteredAddressRepository extends JpaRepository<RegisteredAddress, Long> {

}
