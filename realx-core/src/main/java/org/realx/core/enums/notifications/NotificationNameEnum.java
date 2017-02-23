package org.realx.core.enums.notifications;

public enum NotificationNameEnum {
	PRE_MEETING_REMINDER_NOTIFICATION("PRE_MEETING_REMINDER_NOTIFICATION"), CLOSE_ORDER_PUSH_NOTIFICATION("CLOSE_ORDER_PUSH_NOTIFICATION"), MEETING_CANCELLATION_BY_HOTEL_NOTIFICATION("MEETING_CANCELLATION_BY_HOTEL_NOTIFICATION");
	NotificationNameEnum(String value) {
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
