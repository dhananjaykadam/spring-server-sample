package org.realx.core.repositories.profile;

import org.realx.core.entities.profile.customer.RetailCustomerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetailCustomerProfileRepository extends JpaRepository<RetailCustomerProfile, Long> {

}
