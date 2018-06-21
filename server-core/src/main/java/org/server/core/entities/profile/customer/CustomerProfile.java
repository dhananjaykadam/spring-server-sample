package org.server.core.entities.profile.customer;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.server.core.entities.abstracts.VersionableEntity;
import org.server.core.entities.address.BillingAddress;
import org.server.core.entities.address.ShippingAddress;
import org.server.core.entities.profile.common.Profile;
import org.server.core.enums.profile.CustomerProfileType;

@Entity
@Table
public class CustomerProfile extends VersionableEntity {

	private static final long serialVersionUID = 1L;
	@OneToOne
	private Profile profile;
	@Enumerated(EnumType.STRING)
	private CustomerProfileType customerProfileType;
	@OneToMany
	private Set<ShippingAddress> shippingAddresses;
	@OneToMany
	private Set<BillingAddress> billingAddresses;

	public Set<ShippingAddress> getShippingAddresses() {
		return shippingAddresses;
	}

	public void setShippingAddresses(Set<ShippingAddress> shippingAddresses) {
		this.shippingAddresses = shippingAddresses;
	}

	public Set<BillingAddress> getBillingAddresses() {
		return billingAddresses;
	}

	public void setBillingAddresses(Set<BillingAddress> billingAddresses) {
		this.billingAddresses = billingAddresses;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public CustomerProfileType getCustomerProfileType() {
		return customerProfileType;
	}

	public void setCustomerProfileType(CustomerProfileType customerProfileType) {
		this.customerProfileType = customerProfileType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
