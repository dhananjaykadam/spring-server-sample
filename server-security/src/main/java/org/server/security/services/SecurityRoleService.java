package org.server.security.services;

import org.server.security.abstracts.DefaultSecurityJpaServiceImpl;
import org.server.security.abstracts.SecurityJpaService;
import org.server.security.entities.roles.SecurityRole;
import org.server.security.repositories.SecurityRoleRepository;
import org.springframework.stereotype.Service;

@Service
public class SecurityRoleService extends DefaultSecurityJpaServiceImpl<SecurityRole, SecurityRoleRepository>
		implements SecurityJpaService<SecurityRole> {

}
