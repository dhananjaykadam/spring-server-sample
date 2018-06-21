package org.server.core.enums.email;

public enum EmailNameEnum {
	HOTEL_REGISTRATION_COMPLETED("HOTEL_REGISTRATION_COMPLETED"), PASSWORD_RESET_BY_EMAIL_LINK(
			"PASSWORD_RESET_BY_EMAIL_LINK"), NEW_ORDER_NOTIFICATION_EMAIL("NEW_ORDER_NOTIFICATION_EMAIL"), CLOSE_ORDER_NOTIFICATION_EMAIL("CLOSE_ORDER_NOTIFICATION_EMAIL"), NO_SHOW_NOTIFICATION_EMAIL("NO_SHOW_NOTIFICATION_EMAIL"), CANCEL_ORDER_NOTIFICATION_EMAIL("CANCEL_ORDER_NOTIFICATION_EMAIL");
	EmailNameEnum(String value) {
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
