package org.server.core.entities.profile.customer;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.server.core.entities.abstracts.VersionableEntity;

@Entity
@Table
public class CorporateCustomerProfile extends VersionableEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToOne
	private CustomerProfile customerProfile;

	public CustomerProfile getCustomerProfile() {
		return customerProfile;
	}

	public void setCustomerProfile(CustomerProfile customerProfile) {
		this.customerProfile = customerProfile;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
