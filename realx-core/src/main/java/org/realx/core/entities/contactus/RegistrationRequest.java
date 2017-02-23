package org.realx.core.entities.contactus;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.realx.core.entities.abstracts.VersionableEntity;
import org.realx.core.enums.registration.RegistrationPropertyType;
import org.realx.core.enums.registration.RegistrationRequestType;

@Entity
@Table
public class RegistrationRequest extends VersionableEntity {

	private static final long serialVersionUID = 1L;
	private String name;
	private String email;
	private String contactNo;
	@Enumerated(EnumType.STRING)
	private RegistrationRequestType registrationRequestType;
	@Enumerated(EnumType.STRING)
	private RegistrationPropertyType registrationPropertyType;

	public RegistrationRequestType getRegistrationRequestType() {
		return registrationRequestType;
	}

	public void setRegistrationRequestType(RegistrationRequestType registrationRequestType) {
		this.registrationRequestType = registrationRequestType;
	}

	public RegistrationPropertyType getRegistrationPropertyType() {
		return registrationPropertyType;
	}

	public void setRegistrationPropertyType(RegistrationPropertyType registrationPropertyType) {
		this.registrationPropertyType = registrationPropertyType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
