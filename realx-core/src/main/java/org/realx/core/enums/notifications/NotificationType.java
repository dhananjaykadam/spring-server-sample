package org.realx.core.enums.notifications;

/**
 * 
 * @author {@link <a href="mailto:jaykadam90@gmail.com">Dhananjay Kadam</a>}
 *
 */
public enum NotificationType {
	SYSTEM_GENERATED("SYSTEM_GENERATED"), PROMOTIONAL("PROMOTIONAL"), OTHER("OTHER");
	private String value;

	NotificationType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
