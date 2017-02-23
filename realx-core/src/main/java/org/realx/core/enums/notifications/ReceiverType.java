package org.realx.core.enums.notifications;

public enum ReceiverType {
	INDIVIDUAL("INDIVIDUAL"), GROUP("GROUP"), ALL_USER("ALL_USER");
	String value;

	ReceiverType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
