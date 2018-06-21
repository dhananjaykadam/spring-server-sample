package org.server.core.enums.registration;

public enum RegistrationRequestType {
	PROPERTY_REGISTRATION_REQUEST("PROPERTY_REGISTRATION_REQUEST");
	RegistrationRequestType(String value) {
		this.value = value;
	}

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
