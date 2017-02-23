package org.realx.core.entities.profile.customer;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.realx.core.entities.abstracts.VersionableEntity;

@Entity
@Table
public class RetailCustomerProfile extends VersionableEntity {

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
