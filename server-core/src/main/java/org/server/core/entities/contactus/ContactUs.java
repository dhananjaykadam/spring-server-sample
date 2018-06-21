package org.server.core.entities.contactus;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.server.core.entities.abstracts.VersionableEntity;

@Entity
@Table
public class ContactUs extends VersionableEntity {

	private static final long serialVersionUID = 1L;
	private String name;
	private String email;
	private String contactNo;

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
