package org.server.core.enums.common;

public enum DiscountType {
	PERCENT("PERCENT");
	String value;

	DiscountType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
