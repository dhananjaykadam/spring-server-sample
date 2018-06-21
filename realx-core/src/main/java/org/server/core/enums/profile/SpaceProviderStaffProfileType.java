package org.server.core.enums.profile;

public enum SpaceProviderStaffProfileType {
	MEETING_SPACE_PROVIDER_STAFF_PROFILE("MEETING_SPACE_PROVIDER_STAFF_PROFILE"), EVENT_SPACE_PROVIDER_STAFF_PROFILE(
			"EVENT_SPACE_PROVIDER_STAFF_PROFILE"), LEISURE_SPACE_PROVIDER_STAFF_PROFILE(
					"LEISURE_SPACE_PROVIDER_STAFF_PROFILE"), COWORKING_SPACE_PROVIDER_STAFF_PROFILE(
							"COWORKING_SPACE_PROVIDER_STAFF_PROFILE");
	private String value;

	SpaceProviderStaffProfileType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
