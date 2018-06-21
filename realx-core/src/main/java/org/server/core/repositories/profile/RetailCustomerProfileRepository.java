package org.server.core.repositories.profile;

import org.server.core.entities.profile.customer.RetailCustomerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetailCustomerProfileRepository extends JpaRepository<RetailCustomerProfile, Long> {

}
