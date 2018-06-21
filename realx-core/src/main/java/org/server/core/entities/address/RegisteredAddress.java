package org.server.core.entities.address;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.server.core.entities.abstracts.VersionableEntity;

@Entity
@Table
public class RegisteredAddress extends VersionableEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String organizationName;
	private String attention;
	@OneToOne
	private Address address;

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getAttention() {
		return attention;
	}

	public void setAttention(String attention) {
		this.attention = attention;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
