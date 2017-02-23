package org.realx.security.services;

import org.realx.security.abstracts.DefaultSecurityJpaServiceImpl;
import org.realx.security.abstracts.SecurityJpaService;
import org.realx.security.entities.permissions.SecurityPermission;
import org.realx.security.repositories.SecurityPermissionRepository;
import org.springframework.stereotype.Service;

@Service
public class SecurityPermissionService
		extends DefaultSecurityJpaServiceImpl<SecurityPermission, SecurityPermissionRepository>
		implements SecurityJpaService<SecurityPermission> {

}
