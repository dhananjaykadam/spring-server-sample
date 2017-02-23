package org.realx.core.entities.address;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.realx.core.entities.abstracts.VersionableEntity;

@Entity
@Table
public class BillingAddress extends VersionableEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToOne
	private Address address;
	private String firstName;
	private String middleName;
	private String lastName;
	private boolean isDefault;

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
