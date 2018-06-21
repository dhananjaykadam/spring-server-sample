package org.server.core.enums.profile;

public enum CustomerProfileType {
	RETAIL_CUSTOMER_PROFILE("RETAIL_CUSTOMER_PROFILE"), CORPORATE_CUSTOMER_PROFILE("CORPORATE_CUSTOMER_PROFILE");
	private String value;

	CustomerProfileType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
