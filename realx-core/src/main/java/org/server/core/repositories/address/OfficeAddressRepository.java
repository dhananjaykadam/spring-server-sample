package org.server.core.repositories.address;

import org.server.core.entities.address.OfficeAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeAddressRepository extends JpaRepository<OfficeAddress, Long> {

}
