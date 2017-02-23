package org.realx.core.enums.secure.keys;

public enum AccountResetKeyType {
	GENERATED_BY_EMAIL("GENERATED_BY_EMAIL"), GENERATED_BY_USERNAME("GENERATED_BY_USERNAME");
	AccountResetKeyType(String value) {
		this.value = value;
	}

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
