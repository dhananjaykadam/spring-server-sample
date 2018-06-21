package org.server.core.enums.notifications;

public enum NotificationUniqueName {
	ORDER_REMAINDER_BEF_1_HR("ORDER_REMAINDER_BEF_1_HR");
	private String value;

	NotificationUniqueName(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
