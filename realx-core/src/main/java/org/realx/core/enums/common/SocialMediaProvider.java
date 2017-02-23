package org.realx.core.enums.common;

public enum SocialMediaProvider {
	FACEBOOK("FACEBOOK"), GOOGLE("GOOGLE"), LINKEDIN("LINKEDIN"), TWITTER("TWITTER");
	String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	SocialMediaProvider(String value) {
		this.value = value;
	}
}
