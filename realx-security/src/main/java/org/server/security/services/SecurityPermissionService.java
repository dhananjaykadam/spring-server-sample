package org.server.security.services;

import org.server.security.abstracts.DefaultSecurityJpaServiceImpl;
import org.server.security.abstracts.SecurityJpaService;
import org.server.security.entities.permissions.SecurityPermission;
import org.server.security.repositories.SecurityPermissionRepository;
import org.springframework.stereotype.Service;

@Service
public class SecurityPermissionService
		extends DefaultSecurityJpaServiceImpl<SecurityPermission, SecurityPermissionRepository>
		implements SecurityJpaService<SecurityPermission> {

}
