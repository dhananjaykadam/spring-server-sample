package org.server.security.entities.module;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.server.core.entities.abstracts.VersionableEntity;
import org.server.security.entities.permissions.SecurityPermission;

@Entity
@Table
public class SecurityModule extends VersionableEntity {
	private static final long serialVersionUID = 1L;
	private String name;
	private String displayName;
	@OneToMany(targetEntity = SecurityPermission.class)
	private List<SecurityPermission> permissions;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<SecurityPermission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<SecurityPermission> permissions) {
		this.permissions = permissions;
	}

	public String getName() {
		return name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}
