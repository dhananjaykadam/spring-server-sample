package org.realx.core.enums.devices;

public enum DeviceType {
	ANDROID_MOBILE("ANDROID_MOBILE"), APPLE_MMOBILE("APPLE_MMOBILE");
	String value;

	DeviceType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
