package org.realx.core.dtos.otp;

import org.codehaus.jackson.annotate.JsonProperty;
import org.realx.core.enums.verification.otp.OTPVerificationStatus;

public class OTPObject {
	@JsonProperty
	private String verificationId;
	@JsonProperty
	private String otp;
	@JsonProperty
	private boolean isSucess;
	@JsonProperty
	private String contactNumber;
	@JsonProperty
	private String countryCode;
	@JsonProperty
	private OTPVerificationStatus responseCode;
	@JsonProperty
	private String timeout;
	@JsonProperty
	private String generationSystem;
	@JsonProperty
	private String didAssigned;

	public String getDidAssigned() {
		return didAssigned;
	}

	public void setDidAssigned(String didAssigned) {
		this.didAssigned = didAssigned;
	}

	public String getGenerationSystem() {
		return generationSystem;
	}

	public void setGenerationSystem(String generationSystem) {
		this.generationSystem = generationSystem;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getTimeout() {
		return timeout;
	}

	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}

	public String getVerificationId() {
		return verificationId;
	}

	public void setVerificationId(String verificationId) {
		this.verificationId = verificationId;
	}

	public String getOtp() {
		return otp;
	}

	public OTPVerificationStatus getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(OTPVerificationStatus responseCode) {
		this.responseCode = responseCode;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public boolean isSucess() {
		return isSucess;
	}

	public void setSucess(boolean isSucess) {
		this.isSucess = isSucess;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

}
