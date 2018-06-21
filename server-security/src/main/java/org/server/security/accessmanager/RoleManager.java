package org.server.security.accessmanager;

import org.springframework.stereotype.Component;

@Component
public class RoleManager {
	public String getAdminRoleName() {
		return "ROLE_ADMIN";
	}
	public String getHotelAdminRoleName() {
		return "ROLE_ADMIN";
	}
}
