package org.server.core.enums.profile.role;

public enum FoodSpaceStaffRole {
	ESCALATION_MANAGER("ESCALATION_MANAGER"), POINT_OF_CONTACT("POINT_OF_CONTACT");
	String value;

	FoodSpaceStaffRole(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
