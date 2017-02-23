package org.realx.security.entities.permissions;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.realx.core.entities.abstracts.VersionableEntity;
import org.realx.security.enums.permissions.PermissionType;
import org.springframework.security.core.GrantedAuthority;

@Table
@Entity
public class SecurityPermission extends VersionableEntity implements GrantedAuthority {
	private static final long serialVersionUID = 1L;
	@NotNull
	@Enumerated(EnumType.STRING)
	private PermissionType permissionType;
	private String name;
	private String discription;
	private String displayName;

	public String getName() {
		return name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public PermissionType getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(PermissionType permissionType) {
		this.permissionType = permissionType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return name;
	}

}
