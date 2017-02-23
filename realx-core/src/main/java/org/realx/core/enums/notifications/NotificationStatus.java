package org.realx.core.enums.notifications;

/**
 * 
 * @author {@link <a href="mailto:jaykadam90@gmail.com">Dhananjay Kadam</a>}
 *
 */
public enum NotificationStatus {
	CREATED("CREATED"), SEND("SEND"), DELIVERED("DELIVERED"), READ("READ"), CANCEL("CANCEL");
	private String value;

	NotificationStatus(String value) {
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
