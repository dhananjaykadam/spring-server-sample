package org.server.core.enums.registration;

public enum RegistrationPropertyType {
	COFFEE_SHOP("COFFEE_SHOP"), RESTAURANT("RESTAURANT");
	RegistrationPropertyType(String value) {
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
