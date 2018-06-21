package org.server.core.entities.profile.common;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.server.core.entities.abstracts.VersionableEntity;

@Entity
@Table
public class ContactInfo extends VersionableEntity {

	private static final long serialVersionUID = 1L;
	private String firstName;
	private String midleName;
	private String lastName;
	private String contactLandlineNumberCountryCode;
	private String contactLandlineNumber;

	private String contactMobileNumberCountryCode;
	private String contactMobileNumber;

	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getContactMobileNumberCountryCode() {
		return contactMobileNumberCountryCode;
	}

	public void setContactMobileNumberCountryCode(String contactMobileNumberCountryCode) {
		this.contactMobileNumberCountryCode = contactMobileNumberCountryCode;
	}

	public String getContactMobileNumber() {
		return contactMobileNumber;
	}

	public void setContactMobileNumber(String contactMobileNumber) {
		this.contactMobileNumber = contactMobileNumber;
	}

	public String getMidleName() {
		return midleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getContactLandlineNumberCountryCode() {
		return contactLandlineNumberCountryCode;
	}

	public String getContactLandlineNumber() {
		return contactLandlineNumber;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setMidleName(String midleName) {
		this.midleName = midleName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setContactLandlineNumberCountryCode(String contactLandlineNumberCountryCode) {
		this.contactLandlineNumberCountryCode = contactLandlineNumberCountryCode;
	}

	public void setContactLandlineNumber(String contactLandlineNumber) {
		this.contactLandlineNumber = contactLandlineNumber;
	}

}
