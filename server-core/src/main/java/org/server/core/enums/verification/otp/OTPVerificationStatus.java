package org.server.core.enums.verification.otp;

public enum OTPVerificationStatus {
	DEFAULT("DEFAULT"), VERIFIED("VERIFIED"), NOT_VERIFIED("NOT_VERIFIED"), SENT("SENT"), WAITING("WAITING"), NOT_SENT(
			"NOT_SENT"), TRYING_FALLBACK_SMS_DELIVERED("TRYING_FALLBACK_SMS_DELIVERED");
	OTPVerificationStatus(String value) {
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
