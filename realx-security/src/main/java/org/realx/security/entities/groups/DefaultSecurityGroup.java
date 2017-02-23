package org.realx.security.entities.groups;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.realx.core.entities.abstracts.VersionableEntity;
import org.realx.core.enums.common.UserType;

@Table
@Entity
public class DefaultSecurityGroup extends VersionableEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Enumerated(EnumType.STRING)
	private UserType userType;
	@OneToOne
	private SecurityGroup securityGroup;

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SecurityGroup getSecurityGroup() {
		return securityGroup;
	}

	public void setSecurityGroup(SecurityGroup securityGroup) {
		this.securityGroup = securityGroup;
	}

}
