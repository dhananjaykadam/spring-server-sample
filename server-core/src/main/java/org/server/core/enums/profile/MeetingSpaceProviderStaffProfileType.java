package org.server.core.enums.profile;

public enum MeetingSpaceProviderStaffProfileType {
	FOOD_MEETING_SPACE_PROVIDER_STAFF_PROFILE(
			"FOOD_MEETING_SPACE_PROVIDER_STAFF_PROFILE"), NON_FOOD_MEETING_SPACE_PROVIDER_STAFF_PROFILE(
					"NON_FOOD_MEETING_SPACE_PROVIDER_STAFF_PROFILE");
	private String value;

	MeetingSpaceProviderStaffProfileType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
