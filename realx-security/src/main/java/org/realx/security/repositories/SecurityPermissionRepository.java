package org.realx.security.repositories;

import org.realx.security.entities.permissions.SecurityPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityPermissionRepository extends JpaRepository<SecurityPermission, Long> {

}
