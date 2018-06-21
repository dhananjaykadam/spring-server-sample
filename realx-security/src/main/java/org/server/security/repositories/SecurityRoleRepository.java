package org.server.security.repositories;

import org.server.security.entities.roles.SecurityRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SecurityRoleRepository extends JpaRepository<SecurityRole, Long> {

}
