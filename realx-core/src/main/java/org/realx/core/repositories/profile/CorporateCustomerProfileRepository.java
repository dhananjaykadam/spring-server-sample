package org.realx.core.repositories.profile;

import org.realx.core.entities.profile.customer.CorporateCustomerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateCustomerProfileRepository extends JpaRepository<CorporateCustomerProfile, Long> {

}
