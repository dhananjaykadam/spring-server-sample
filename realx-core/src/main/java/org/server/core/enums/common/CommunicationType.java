package org.server.core.enums.common;

public enum CommunicationType {
	MOBILE("MOBILE"), PHONE("PHONE"), EMAIL("EMAIL");
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	CommunicationType(String value) {
		this.value = value;
	}
}
