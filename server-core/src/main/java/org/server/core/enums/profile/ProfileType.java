package org.server.core.enums.profile;

public enum ProfileType {
	CUSTOMER_PROFILE("CUSTOMER_PROFILE"), SPACE_PROVIDER_STAFF_PROFILE("SPACE_PROVIDER_STAFF_PROFILE");
	private String value;

	ProfileType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
