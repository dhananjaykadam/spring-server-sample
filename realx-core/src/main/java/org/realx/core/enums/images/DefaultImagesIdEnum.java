package org.realx.core.enums.images;

public enum DefaultImagesIdEnum {
	DEFAULT_SPACE_COVER_PHOTO("DEFAULT_SPACE_COVER_PHOTO"), DEFAULT_USER_PROFILE_PHOTO("DEFAULT_USER_PROFILE_PHOTO");
	DefaultImagesIdEnum(String value) {
		this.value = value;
	}

	String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
