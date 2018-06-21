package org.server.security.entities.groups;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.server.core.entities.abstracts.VersionableEntity;
import org.server.core.entities.user.User;
import org.server.security.entities.roles.SecurityRole;

@Entity
@Table
public class SecurityGroup extends VersionableEntity {
	private static final long serialVersionUID = 1L;
	@ManyToMany(targetEntity = User.class)
	private Set<User> users;
	@ManyToMany(targetEntity = SecurityRole.class, fetch = FetchType.EAGER)
	private Set<SecurityRole> securityRoles;
	private String groupName;
	private String displayName;
	private String description;

	public String getGroupName() {
		return groupName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<SecurityRole> getSecurityRoles() {
		return securityRoles;
	}

	public void setSecurityRoles(Set<SecurityRole> securityRoles) {
		this.securityRoles = securityRoles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
