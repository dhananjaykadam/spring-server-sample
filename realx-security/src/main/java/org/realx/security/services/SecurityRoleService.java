package org.realx.security.services;

import org.realx.security.abstracts.DefaultSecurityJpaServiceImpl;
import org.realx.security.abstracts.SecurityJpaService;
import org.realx.security.entities.roles.SecurityRole;
import org.realx.security.repositories.SecurityRoleRepository;
import org.springframework.stereotype.Service;

@Service
public class SecurityRoleService extends DefaultSecurityJpaServiceImpl<SecurityRole, SecurityRoleRepository>
		implements SecurityJpaService<SecurityRole> {

}
