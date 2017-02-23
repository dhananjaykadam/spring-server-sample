package org.realx.core.enums.profile.role;

public enum SpaceStaffRole {
	ESCALATION_MANAGER("ESCALATION_MANAGER"), POINT_OF_CONTACT("POINT_OF_CONTACT");
	String value;

	SpaceStaffRole(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
