package org.server.core.enums.common;

/**
 * 
 * @author {@link <a href="mailto:jaykadam90@gmail.com">Dhananjay Kadam</a>}
 *
 */
public enum UserType {
	ADMIN("ADMIN"), CUSTOMER("CUSTOMER"), SPACE_PROVIDER("SPACE_PROVIDER"), SPACE_STAFF(
			"SPACE_STAFF"), FOOD_SPACE_STAFF("FOOD_SPACE_STAFF");
	private String value;

	UserType(String value) {
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
