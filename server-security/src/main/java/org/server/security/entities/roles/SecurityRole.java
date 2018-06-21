package org.server.security.entities.roles;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.server.core.entities.abstracts.VersionableEntity;
import org.server.security.entities.module.SecurityModule;
import org.server.security.entities.permissions.SecurityPermission;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table
public class SecurityRole extends VersionableEntity implements GrantedAuthority {
	private static final long serialVersionUID = 1L;
	private String name;
	private String displayName;
	private String description;
	@ManyToMany(targetEntity = SecurityPermission.class, fetch = FetchType.EAGER)
	private Set<SecurityPermission> permissions;

	@ManyToMany(targetEntity = SecurityModule.class)
	private Set<SecurityModule> securityModules;

	public Set<SecurityModule> getSecurityModules() {
		return securityModules;
	}

	public void setSecurityModules(Set<SecurityModule> securityModules) {
		this.securityModules = securityModules;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<SecurityPermission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<SecurityPermission> permissions) {
		this.permissions = permissions;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String getAuthority() {
		return name;
	}

}
