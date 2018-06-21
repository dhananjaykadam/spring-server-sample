package org.server.core.enums.address;

public enum AddressType {
	BILLING("BILLING"), SHIPPING("SHIPPING"), OFFICE("OFFICE"), REGISTERED("REGISTERED"), SPACE_LOCATION(
			"SPACE_LOCATION");
	String value;

	AddressType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
