package org.server.core.enums.common;

public enum LoginClientType {
	ANDROID("ANDROID"), BROWSER("BROWSER"), IOS("IOS");
	String value;

	LoginClientType(String value) {
		this.value = value;
	}
}
